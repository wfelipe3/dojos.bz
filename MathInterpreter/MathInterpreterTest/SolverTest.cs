using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace MathInterpreterTest
{
    [TestClass]
    public class SolverTest
    {
        private readonly Solver _solver = new Solver();

        [TestMethod]
        public void Given1Plus1ThenReturn2()
        {
            AssertSolver("1+1", 2);
        }
        [TestMethod]
        public void Given1Plus2ThenReturn3()
        {
            AssertSolver("1+2", 3);
        }

        [TestMethod]
        public void Given1Minus1ThenReturn0()
        {
            AssertSolver("1-1", 0);
        }

        [TestMethod]
        public void Given1Plus1Plus1ThenReturn3()
        {
            AssertSolver("1+1+1", 3);
        }

        [TestMethod]
        public void GivenTenPlusTenThenReturn20()
        {
            AssertSolver("10+10",20);
        }

        [TestMethod]
        public void GivenFourAddings()
        {
            AssertSolver("1+2+3+4",10);
            AssertSolver("10+20+30+40",100);
        }

        [TestMethod]
        public void GivenXTimesYThenReturnXtimesY()
        {
            AssertSolver("5*6", 30);
            AssertSolver("10*50", 500);
        }

        private void AssertSolver(string expression, int actual)
        {
            Assert.AreEqual(Solver.Resolve(expression), actual);
        }

    }


}
