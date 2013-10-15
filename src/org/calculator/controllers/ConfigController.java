package org.calculator.controllers;

import org.calculator.business.IConfigManager;
import org.calculator.models.CalculatorMethodParam;
import org.calculator.models.ParamConfig;
import org.calculator.models.viewmodels.JSONJTableModel;
import org.calculator.models.viewmodels.JSONJTableResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles param configuration operations
 * 
 * @author khalil.amdouni
 * 
 */
@Controller
public class ConfigController {

	private IConfigManager configManager;

	/**
	 * Getting all configs of a param
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param paramId
	 * @return JSONJTableModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/getParamConfigs/{paramId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableModel<ParamConfig> getParamConfigs(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@PathVariable("paramId") long paramId) {
		return new JSONJTableModel<ParamConfig>("OK",
				this.configManager.getParamConfigs(paramId, jtStartIndex,
						jtPageSize),
				this.configManager.getParamConfigsCount(paramId));
	}

	/**
	 * Adding param config
	 * 
	 * @param paramConfig
	 * @param paramId
	 * @param result
	 * @return JSONJTableResponseModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/addParamConfig/{paramId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<ParamConfig> addParamConfig(
			@ModelAttribute ParamConfig paramConfig,
			@PathVariable("paramId") long paramId, BindingResult result) {
		CalculatorMethodParam param = new CalculatorMethodParam();
		param.setId(paramId);
		paramConfig.setParam(param);
		return new JSONJTableResponseModel<ParamConfig>("OK",
				this.configManager.saveParamConfig(paramConfig));
	}

	/**
	 * Updating param config
	 * 
	 * @param paramConfig
	 * @param result
	 * @return JSONJTableResponseModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/updateParamConfig", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<ParamConfig> updateParamConfig(
			@ModelAttribute ParamConfig paramConfig, BindingResult result) {
		return new JSONJTableResponseModel<ParamConfig>("OK",
				this.configManager.saveParamConfig(paramConfig));
	}

	/**
	 * Deleting param config
	 * 
	 * @param paramConfigId
	 * @return JSONJTableResponseModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/deleteParamConfig", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<ParamConfig> deleteParamConfig(
			@RequestParam long paramConfigId) {
		configManager.deleteParamConfig(paramConfigId);
		return new JSONJTableResponseModel<ParamConfig>("OK");
	}

	public IConfigManager getConfigManager() {
		return configManager;
	}

	@Autowired
	@Qualifier("configManager")
	public void setConfigManager(IConfigManager configManager) {
		this.configManager = configManager;
	}

}
