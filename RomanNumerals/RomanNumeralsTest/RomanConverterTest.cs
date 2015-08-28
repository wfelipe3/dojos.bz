using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using RomanNumerals;

namespace RomanNumeralsTest
{
    [TestClass]
    public class RomanConverterTest
    {
        
        [TestMethod]
        public void Given1To3ThenReturnI()
        {
            AssertRomanNumeral("I", 1);
            AssertRomanNumeral("II", 2);
            AssertRomanNumeral("III", 3);

        }

        [TestMethod]
        public void Given4ThenReturnIV()
        {
            AssertRomanNumeral("IV",4);
        }

        [TestMethod]
        public void Given5ThenReturnV()
        {
            AssertRomanNumeral("V",5);
        }

        [TestMethod]
        public void Given10ThenReturnX()
        {
            AssertRomanNumeral("X",10);
        }

        [TestMethod]
        public void Given50ThenReturnL()
        {
            AssertRomanNumeral("L",50);
        }

        [TestMethod]
        public void Given100ThenReturnC()
        {
            AssertRomanNumeral("C",100);
        }

        [TestMethod]
        public void Given500ThenReturnD()
        {
            AssertRomanNumeral("D",500);
        }

        [TestMethod]
        public void Given1000ThenReturnM()
        {
            AssertRomanNumeral("M",1000);
        }

        [TestMethod]
        public void Given6To8ThenReturnVIToVIII()
        {
            AssertRomanNumeral("VI",6);
            AssertRomanNumeral("VII",7);
            AssertRomanNumeral("VIII",8);
        }

        [TestMethod]
        public void Given11to13ThenReturnXItoXIII()
        {
            AssertRomanNumeral("XI", 11);
            AssertRomanNumeral("XII", 12);
            AssertRomanNumeral("XIII", 13);
        }

        [TestMethod]
        public void Given21ThenReturnXXI()
        {
            AssertRomanNumeral("XXI", 21);
        }

        [TestMethod]
        public void Given9ThenReturnIX()
        {
            AssertRomanNumeral("IX", 9);
        }

        [TestMethod]
        public void Given19ThenReturnXIX()
        {
            AssertRomanNumeral("XIX", 19);
        }

        [TestMethod]
        public void Given99ThenReturXCIX()
        {
            AssertRomanNumeral("XCIX",99);
        }

        private static void AssertRomanNumeral(string expected,int given)
        {
            Assert.AreEqual(expected, new RomanConverter().ConvertToRoman(given));
        }
    }
}
