package org.calculator.controllers;

import org.calculator.business.IConfigManager;
import org.calculator.models.CalculationConfig;
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
	JSONJTableModel<CalculationConfig> getParamConfigs(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@PathVariable("paramId") long paramId) {
		return new JSONJTableModel<CalculationConfig>("OK",
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
	JSONJTableResponseModel<CalculationConfig> addParamConfig(
			@ModelAttribute CalculationConfig paramConfig,
			@PathVariable("paramId") long paramId, BindingResult result) {
		paramConfig.setParamId(paramId);
		return new JSONJTableResponseModel<CalculationConfig>("OK",
				this.configManager.save(paramConfig));
	}

	/**
	 * Getting all configs of a web scenario
	 * 
	 * @param jtStartIndex
	 * @param jtPageSize
	 * @param scenarioId
	 * @return JSONJTableModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/getWebScenarioConfigs/{scenarioId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableModel<CalculationConfig> getWebScenarioConfigs(
			@RequestParam int jtStartIndex, @RequestParam int jtPageSize,
			@PathVariable("scenarioId") long scenarioId) {
		return new JSONJTableModel<CalculationConfig>("OK",
				this.configManager.getWebScenarioConfigs(scenarioId,
						jtStartIndex, jtPageSize),
				this.configManager.getWebScenarioConfigsCount(scenarioId));
	}

	/**
	 * Adding web scenario config
	 * 
	 * @param wbScenarioConfig
	 * @param scenarioId
	 * @param result
	 * @return JSONJTableResponseModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/addWebScenarioConfig/{scenarioId}", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<CalculationConfig> addWebScenarioConfig(
			@ModelAttribute CalculationConfig wbScenarioConfig,
			@PathVariable("scenarioId") long scenarioId, BindingResult result) {
		wbScenarioConfig.setScenarioId(scenarioId);
		return new JSONJTableResponseModel<CalculationConfig>("OK",
				this.configManager.save(wbScenarioConfig));
	}

	/**
	 * Updating calculation config
	 * 
	 * @param paramConfig
	 * @param result
	 * @return JSONJTableResponseModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/updateCalculationConfig", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<CalculationConfig> updateParamConfig(
			@ModelAttribute CalculationConfig paramConfig, BindingResult result) {
		return new JSONJTableResponseModel<CalculationConfig>("OK",
				this.configManager.save(paramConfig));
	}

	/**
	 * Deleting calculation config
	 * 
	 * @param paramConfigId
	 * @return JSONJTableResponseModel; Adapter for JTable framework
	 */
	@RequestMapping(value = "/deleteCalculationConfig", method = RequestMethod.POST, headers = "Accept=application/json")
	public @ResponseBody
	JSONJTableResponseModel<CalculationConfig> deleteParamConfig(
			@RequestParam long paramConfigId) {
		configManager.delete(paramConfigId);
		return new JSONJTableResponseModel<CalculationConfig>("OK");
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
