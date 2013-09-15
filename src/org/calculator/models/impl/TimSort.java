package org.calculator.models.impl;

import org.calculator.models.IAlgorithme;

public class TimSort implements IAlgorithme {

	private String id;
	private String name;

	private Object[] data;
	private double[] sortData;

	private int stackSize = 0;
	private int[] runBase;
	private int[] runLen;
	private final int MIN_MERGE = 32;

	private double[] a;

	private static final int MIN_GALLOP = 7;

	private int minGallop = MIN_GALLOP;

	private static final int INITIAL_TMP_STORAGE_LENGTH = 256;

	private double[] tmp = null;

	private void init(double[] a) {
	        this.a = a;

	        int len = a.length;
	        double[] newArray = (double[]) new double[len < 2 * INITIAL_TMP_STORAGE_LENGTH ?
	                                        len >>> 1 : INITIAL_TMP_STORAGE_LENGTH];
	        tmp = newArray;
	        int stackLen = (len <    120  ?  5 :
	                        len <   1542  ? 10 :
	                        len < 119151  ? 19 : 40);
	        runBase = new int[stackLen];
	        runLen = new int[stackLen];
	}
	
	public double[] getSortData() {
		return sortData;
	}

	public void setSortData(double[] sortData) {
		this.sortData = sortData;
	}

	public Object[] getData() {
		return data;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TimSort() {
		super();
	}

	public TimSort(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public void run() {
		sort(this.sortData, 0, this.sortData.length);
	}

	private void rangeCheck(int arrayLen, int fromIndex, int toIndex) {
		if (fromIndex > toIndex)
			throw new IllegalArgumentException("fromIndex(" + fromIndex
					+ ") > toIndex(" + toIndex + ")");
		if (fromIndex < 0)
			throw new ArrayIndexOutOfBoundsException(fromIndex);
		if (toIndex > arrayLen)
			throw new ArrayIndexOutOfBoundsException(toIndex);
	}

	private static void reverseRange(double[] tab, int lo, int hi) {
		hi--;
		while (lo < hi) {
			double t = tab[lo];
			tab[lo++] = tab[hi];
			tab[hi--] = t;
		}
	}

	private static int countRunAndMakeAscending(double[] tab, int lo, int hi) {
		int runHi = lo + 1;
		if (runHi == hi)
			return 1;

		if (tab[runHi++] < tab[lo]) { 
			while (runHi < hi && tab[runHi] < tab[runHi - 1])
				runHi++;
			reverseRange(tab, lo, runHi);
		} else { 
			while (runHi < hi && tab[runHi] >= tab[runHi - 1])
				runHi++;
		}

		return runHi - lo;
	}

	private static void binarySort(double[] tab, int lo, int hi, int start) {
		if (start == lo)
			start++;
		for (; start < hi; start++) {
			double pivot = tab[start];

			int left = lo;
			int right = start;

			while (left < right) {
				int mid = (left + right) >>> 1;
				if (pivot < tab[mid])
					right = mid;
				else
					left = mid + 1;
			}
			int n = start - left;
			switch (n) {
			case 2:
				tab[left + 2] = tab[left + 1];
			case 1:
				tab[left + 1] = tab[left];
				break;
			default:
				System.arraycopy(tab, left, tab, left + 1, n);
			}
			tab[left] = pivot;
		}
	}

	private int minRunLength(int n) {
		assert n >= 0;
		int r = 0; 
		while (n >= MIN_MERGE) {
			r |= (n & 1);
			n >>= 1;
		}
		return n + r;
	}

	public void pushRun(int runBase, int runLen) {
		this.runBase[stackSize] = runBase;
		this.runLen[stackSize] = runLen;
		stackSize++;
	}

	private int gallopRight(double key, double[] a, int base, int len, int hint) {
		assert len > 0 && hint >= 0 && hint < len;

		int ofs = 1;
		int lastOfs = 0;
		if (key < a[base + hint]) {
			int maxOfs = hint + 1;
			while (ofs < maxOfs && key < a[base + hint - ofs]) {
				lastOfs = ofs;
				ofs = (ofs << 1) + 1;
				if (ofs <= 0) 
					ofs = maxOfs;
			}
			if (ofs > maxOfs)
				ofs = maxOfs;

			int tmp = lastOfs;
			lastOfs = hint - ofs;
			ofs = hint - tmp;
		} else { 
			int maxOfs = len - hint;
			while (ofs < maxOfs && key >= a[base + hint + ofs]) {
				lastOfs = ofs;
				ofs = (ofs << 1) + 1;
				if (ofs <= 0) 
					ofs = maxOfs;
			}
			if (ofs > maxOfs)
				ofs = maxOfs;

			lastOfs += hint;
			ofs += hint;
		}


		lastOfs++;
		while (lastOfs < ofs) {
			int m = lastOfs + ((ofs - lastOfs) >>> 1);

			if (key < a[base + m])
				ofs = m; 
			else
				lastOfs = m + 1; 
		}
		return ofs;
	}


    private void mergeLo(int base1, int len1, int base2, int len2) {

        double[] a = this.a; 
        double[] tmp = ensureCapacity(len1);
        System.arraycopy(a, base1, tmp, 0, len1);

        int cursor1 = 0;       
        int cursor2 = base2;   
        int dest = base1;     

        a[dest++] = a[cursor2++];
        if (--len2 == 0) {
            System.arraycopy(tmp, cursor1, a, dest, len1);
            return;
        }
        if (len1 == 1) {
            System.arraycopy(a, cursor2, a, dest, len2);
            a[dest + len2] = tmp[cursor1]; 
            return;
        }

        int minGallop = this.minGallop;    
    outer:
        while (true) {
            int count1 = 0; 
            int count2 = 0; 

            do {
                assert len1 > 1 && len2 > 0;
                if (a[cursor2] < tmp[cursor1]) {
                    a[dest++] = a[cursor2++];
                    count2++;
                    count1 = 0;
                    if (--len2 == 0)
                        break outer;
                } else {
                    a[dest++] = tmp[cursor1++];
                    count1++;
                    count2 = 0;
                    if (--len1 == 1)
                        break outer;
                }
            } while ((count1 | count2) < minGallop);


            do {
                assert len1 > 1 && len2 > 0;
                count1 = gallopRight(a[cursor2], tmp, cursor1, len1, 0);
                if (count1 != 0) {
                    System.arraycopy(tmp, cursor1, a, dest, count1);
                    dest += count1;
                    cursor1 += count1;
                    len1 -= count1;
                    if (len1 <= 1) 
                        break outer;
                }
                a[dest++] = a[cursor2++];
                if (--len2 == 0)
                    break outer;

                count2 = gallopLeft(tmp[cursor1], a, cursor2, len2, 0);
                if (count2 != 0) {
                    System.arraycopy(a, cursor2, a, dest, count2);
                    dest += count2;
                    cursor2 += count2;
                    len2 -= count2;
                    if (len2 == 0)
                        break outer;
                }
                a[dest++] = tmp[cursor1++];
                if (--len1 == 1)
                    break outer;
                minGallop--;
            } while (count1 >= MIN_GALLOP | count2 >= MIN_GALLOP);
            if (minGallop < 0)
                minGallop = 0;
            minGallop += 2;  
        } 
        this.minGallop = minGallop < 1 ? 1 : minGallop;  

        if (len1 == 1) {
            assert len2 > 0;
            System.arraycopy(a, cursor2, a, dest, len2);
            a[dest + len2] = tmp[cursor1]; 
        } else if (len1 == 0) {
            throw new IllegalArgumentException(
                "Comparison method violates its general contract!");
        } else {
            assert len2 == 0;
            assert len1 > 1;
            System.arraycopy(tmp, cursor1, a, dest, len1);
        }
    }

    private void mergeHi(int base1, int len1, int base2, int len2) {

        double[] a = this.a; 
        double[] tmp = ensureCapacity(len2);
        System.arraycopy(a, base2, tmp, 0, len2);

        int cursor1 = base1 + len1 - 1;  
        int cursor2 = len2 - 1;         
        int dest = base2 + len2 - 1;    

        a[dest--] = a[cursor1--];
        if (--len1 == 0) {
            System.arraycopy(tmp, 0, a, dest - (len2 - 1), len2);
            return;
        }
        if (len2 == 1) {
            dest -= len1;
            cursor1 -= len1;
            System.arraycopy(a, cursor1 + 1, a, dest + 1, len1);
            a[dest] = tmp[cursor2];
            return;
        }

        int minGallop = this.minGallop;    
    outer:
        while (true) {
            int count1 = 0; 
            int count2 = 0; 


            do {
                assert len1 > 0 && len2 > 1;
                if (tmp[cursor2] < a[cursor1]) {
                    a[dest--] = a[cursor1--];
                    count1++;
                    count2 = 0;
                    if (--len1 == 0)
                        break outer;
                } else {
                    a[dest--] = tmp[cursor2--];
                    count2++;
                    count1 = 0;
                    if (--len2 == 1)
                        break outer;
                }
            } while ((count1 | count2) < minGallop);


            do {
                assert len1 > 0 && len2 > 1;
                count1 = len1 - gallopRight(tmp[cursor2], a, base1, len1, len1 - 1);
                if (count1 != 0) {
                    dest -= count1;
                    cursor1 -= count1;
                    len1 -= count1;
                    System.arraycopy(a, cursor1 + 1, a, dest + 1, count1);
                    if (len1 == 0)
                        break outer;
                }
                a[dest--] = tmp[cursor2--];
                if (--len2 == 1)
                    break outer;

                count2 = len2 - gallopLeft(a[cursor1], tmp, 0, len2, len2 - 1);
                if (count2 != 0) {
                    dest -= count2;
                    cursor2 -= count2;
                    len2 -= count2;
                    System.arraycopy(tmp, cursor2 + 1, a, dest + 1, count2);
                    if (len2 <= 1)  // len2 == 1 || len2 == 0
                        break outer;
                }
                a[dest--] = a[cursor1--];
                if (--len1 == 0)
                    break outer;
                minGallop--;
            } while (count1 >= MIN_GALLOP | count2 >= MIN_GALLOP);
            if (minGallop < 0)
                minGallop = 0;
            minGallop += 2;  
        } 
        this.minGallop = minGallop < 1 ? 1 : minGallop;  

        if (len2 == 1) {
            assert len1 > 0;
            dest -= len1;
            cursor1 -= len1;
            System.arraycopy(a, cursor1 + 1, a, dest + 1, len1);
            a[dest] = tmp[cursor2]; 
        } else if (len2 == 0) {
            throw new IllegalArgumentException(
                "Comparison method violates its general contract!");
        } else {
            assert len1 == 0;
            assert len2 > 0;
            System.arraycopy(tmp, 0, a, dest - (len2 - 1), len2);
        }
    }

    private double[] ensureCapacity(int minCapacity) {
        if (tmp.length < minCapacity) {
            int newSize = minCapacity;
            newSize |= newSize >> 1;
            newSize |= newSize >> 2;
            newSize |= newSize >> 4;
            newSize |= newSize >> 8;
            newSize |= newSize >> 16;
            newSize++;

            if (newSize < 0) 
                newSize = minCapacity;
            else
                newSize = Math.min(newSize, a.length >>> 1);

            double[] newArray = (double[]) new double[newSize];
            tmp = newArray;
        }
        return tmp;
    }
	
	private static int gallopLeft(double key, double[] a, int base, int len, int hint) {
		assert len > 0 && hint >= 0 && hint < len;
		int lastOfs = 0;
		int ofs = 1;
		if (key < a[base + hint]) {
			int maxOfs = len - hint;
			while (ofs < maxOfs && key < a[base + hint + ofs]) {
				lastOfs = ofs;
				ofs = (ofs << 1) + 1;
				if (ofs <= 0) 
					ofs = maxOfs;
			}
			if (ofs > maxOfs)
				ofs = maxOfs;

			lastOfs += hint;
			ofs += hint;
		} else {
			final int maxOfs = hint + 1;
			while (ofs < maxOfs && key <= a[base + hint - ofs]) {
				lastOfs = ofs;
				ofs = (ofs << 1) + 1;
				if (ofs <= 0) 
					ofs = maxOfs;
			}
			if (ofs > maxOfs)
				ofs = maxOfs;

			int tmp = lastOfs;
			lastOfs = hint - ofs;
			ofs = hint - tmp;
		}

		lastOfs++;
		while (lastOfs < ofs) {
			int m = lastOfs + ((ofs - lastOfs) >>> 1);

			if (key > a[base + m])
				lastOfs = m + 1; 
			else
				ofs = m; 
		}
		assert lastOfs == ofs; 
		return ofs;
	}

	private void mergeAt(int i) {

		int base1 = runBase[i];
		int len1 = runLen[i];
		int base2 = runBase[i + 1];
		int len2 = runLen[i + 1];

		runLen[i] = len1 + len2;
		if (i == stackSize - 3) {
			runBase[i + 1] = runBase[i + 2];
			runLen[i + 1] = runLen[i + 2];
		}
		stackSize--;

		int k = gallopRight(a[base2], a, base1, len1, 0);
		assert k >= 0;
		base1 += k;
		len1 -= k;
		if (len1 == 0)
			return;

		len2 = gallopLeft(a[base1 + len1 - 1], a, base2, len2, len2 - 1);
		assert len2 >= 0;
		if (len2 == 0)
			return;

		if (len1 <= len2)
			mergeLo(base1, len1, base2, len2);
		else
			mergeHi(base1, len1, base2, len2);
	}

	public void mergeCollapse() {
		while (stackSize > 1) {
			int n = stackSize - 2;
			if (n > 0 && runLen[n - 1] <= runLen[n] + runLen[n + 1]) {
				if (runLen[n - 1] < runLen[n + 1])
					n--;
				mergeAt(n);
			} else if (runLen[n] <= runLen[n + 1]) {
				mergeAt(n);
			} else {
				break; 
			}
		}
	}

    public void mergeForceCollapse() {
        while (stackSize > 1) {
            int n = stackSize - 2;
            if (n > 0 && runLen[n - 1] < runLen[n + 1])
                n--;
            mergeAt(n);
        }
    }
	
	public void sort(double[] tab, int lo, int hi) {

		rangeCheck(tab.length, lo, hi);
		int nRemaining = hi - lo;
		if (nRemaining < 2)
			return; 

		if (nRemaining < MIN_MERGE) {
			int initRunLen = countRunAndMakeAscending(tab, lo, hi);
			binarySort(tab, lo, hi, lo + initRunLen);
			return;
		}

		init(tab);
		int minRun = minRunLength(nRemaining);
		do {
			int runLen = countRunAndMakeAscending(tab, lo, hi);

			if (runLen < minRun) {
				int force = nRemaining <= minRun ? nRemaining : minRun;
				binarySort(tab, lo, lo + force, lo + runLen);
				runLen = force;
			}

			pushRun(lo, runLen);
			mergeCollapse();

			lo += runLen;
			nRemaining -= runLen;
		} while (nRemaining != 0);

		assert lo == hi;
		mergeForceCollapse();
		assert stackSize == 1;
	}

	@Override
	public void setData(Object[] data) {
		this.data = data;
	}

	@Override
	public void transformData() {
		this.sortData = new double[this.data.length];
		for (int i = 0; i < this.sortData.length; i++) {
			this.sortData[i] = (Double) this.data[i];
		}
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
