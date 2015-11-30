using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace TrieTest
{
    [TestClass]
    public class UnitTest1
    {
        private TrieStructure _trieStructure = new TrieStructure();

        [TestInitialize]
        public void ResetTrie()
        {
            _trieStructure = new TrieStructure();
        }

        [TestMethod]
        public void ReadWordEmpty()
        {
            AssertContains("");
        }

        [TestMethod]
        public void SearchWordthatDoesNotExist()
        {
            AssertNotContains("casa");
        }

        [TestMethod]
        public void InsertOneWordAndSearchIt()
        {
            _trieStructure.Insert("c");
            AssertContains("c");
        }

        [TestMethod]
        public void InsertTwoWordsAndSearchThem()
        {
            _trieStructure.Insert("a");
            _trieStructure.Insert("c");
            AssertContains("c");
            AssertContains("a");
        }

        [TestMethod]
        public void InsertTwoLetterWordAndSearch()
        {
            _trieStructure.Insert("ca");
            AssertContains("ca");
            AssertNotContains("cb");
        }

        private void AssertContains(string word)
        {
            Assert.AreEqual(_trieStructure.Contains(word), true);
        }

        private void AssertNotContains(string word)
        {
            Assert.AreEqual(_trieStructure.Contains(word), false);
        }
    }
}
