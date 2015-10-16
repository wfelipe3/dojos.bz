using System;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using quicksort;

namespace quicksort_test
{
    [TestClass]
    public class QuickSortTest
    {
        [TestMethod]
        public void SortZeroAndOneSizeList()
        {
            AssertQuickSort(BuildArr(), BuildArr());
            AssertQuickSort(BuildArr(1), BuildArr(1));
        }

        [TestMethod]
        public void SortTwoSizeList()
        {
            AssertQuickSort(BuildArr( 435, 56 ), BuildArr( 56 ,435));
            AssertQuickSort(BuildArr( 435, 506 ), BuildArr( 435,506));
            AssertQuickSort(BuildArr( 4353, 56 ), BuildArr( 56 ,4353));
        }

        [TestMethod]
        public void SortThreeSizeList()
        {
            AssertQuickSort(BuildArr(435, 56,100), BuildArr(56, 100,435));
            AssertQuickSort(BuildArr(100,56,435), BuildArr(56, 100, 435));
            AssertQuickSort(BuildArr(56,100,435), BuildArr(56, 100, 435));
            AssertQuickSort(BuildArr(435,100,56), BuildArr(56, 100, 435));
        }

        [TestMethod]
        public void SortFourSizeList()
        {
            AssertQuickSort(BuildArr(435, 56, 100,2), BuildArr(2,56, 100, 435));
        }

        private void AssertQuickSort(int[] actual, int[] expected)
        {
            CollectionAssert.AreEqual(QuickSort.Sort(actual),expected);
        }

        private int[] BuildArr(params int[] values)
        {
            return values;
        }

    }
}
