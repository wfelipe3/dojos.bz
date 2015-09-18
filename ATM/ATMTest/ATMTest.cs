using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ATM;


namespace ATMTest
{
    [TestClass]
    public class ATMTest
    {
        [TestMethod]
        public void GivenZeroThenReturnZero()
        {
            
            assertMap(new Dictionary<int, int>()
            {
                {1,0},
                {2,0},
                {5,0},
                {10,0},
                {20,0},
                {50,0}
            }, ATM.ATM.Money(0));
        }

        [TestMethod]
        public void GivenExactQuantityReturnExactQuantity()
        {
            assertMap(ExpectedDict(new int[]{1,0,0,0,0,0}), ATM.ATM.Money(1));
            assertMap(ExpectedDict(new int[] { 0, 1, 0, 0, 0, 0 }), ATM.ATM.Money(2));
            assertMap(ExpectedDict(new int[] { 0, 0, 1, 0, 0, 0 }), ATM.ATM.Money(5));
            assertMap(ExpectedDict(new int[] { 0, 0, 0, 1, 0, 0 }), ATM.ATM.Money(10));
            assertMap(ExpectedDict(new int[] { 0, 0, 0, 0, 1, 0 }), ATM.ATM.Money(20));
            assertMap(ExpectedDict(new int[] { 0, 0, 0, 0, 0, 1 }), ATM.ATM.Money(50));

        }

        [TestMethod]
        public void GivenThreeReturnOneAndTwo()
        {
            assertMap(ExpectedDict(new int[] {1, 1, 0, 0, 0, 0}), ATM.ATM.Money(3));
            assertMap(ExpectedDict(new int[] {0, 2, 0, 0, 0, 0}), ATM.ATM.Money(4));
            assertMap(ExpectedDict(new int[] {1, 0, 1, 0, 0, 0}), ATM.ATM.Money(6));
            assertMap(ExpectedDict(new int[] { 1, 1, 1, 0, 0, 0 }), ATM.ATM.Money(8));
            assertMap(ExpectedDict(new int[] { 1, 1, 1, 1, 1, 1 }), ATM.ATM.Money(88));
            assertMap(ExpectedDict(new int[] { 1, 1, 1, 1, 1, 3 }), ATM.ATM.Money(188));
        }

        public static Dictionary<int, int> ExpectedDict(int[] amounts)
        {
            return new Dictionary<int, int>()
                {
                    {1,amounts[0]},
                    {2,amounts[1]},
                    {5,amounts[2]},
                    {10,amounts[3]},
                    {20,amounts[4]},
                    {50,amounts[5]}
                };
        }


        private void assertMap(Dictionary<int, int> expected, Dictionary<int, int> result)
        {
            Assert.AreEqual( expected.Count, result.Count );

            Assert.IsTrue(expected.Keys.Count(x => result[x] == expected[x]) == expected.Count );
            
        }

        
    }
}
