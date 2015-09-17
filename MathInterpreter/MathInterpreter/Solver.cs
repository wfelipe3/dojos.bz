using System;
using System.Runtime.Remoting.Messaging;

namespace MathInterpreterTest
{
    public class Solver
    {
        public static int Resolve(string expression)
        {
            char[] operators = new[] {'+', '-', '*'};
            int operatorIndex = expression.IndexOf('+');
            operatorIndex = operatorIndex == -1 ? expression.IndexOf('-') : operatorIndex;
            operatorIndex = operatorIndex == -1 ? expression.IndexOf('*') : operatorIndex;
            string[] parameters = expression.Split(operators);
            if (parameters.Length == 1)
            {
                return ToInt(parameters[0]);
            }
            ICommand command = GetCommand(expression);
            int result = ToInt(parameters[0]);
            string parameter = expression.Substring(0, operatorIndex);
            if (parameters.Length>1)
            {
                result = command.Evaluate(ToInt(parameter), expression.Substring(operatorIndex+1));
            }
            
            return result;
        }

        private static ICommand GetCommand(string expression)
        {
            string[] parameters;
            if (expression.Contains("-"))
            {
                return new SubstractionCommand();
            }
            else if(expression.Contains("+"))
            {
                return new AddCommand();
            }
            else
            {
                return new ProductCommand();
            }
        }

        private static int ToInt(string parameter)
        {
            return Int32.Parse(parameter);
        }

        private interface ICommand
        {
            int Evaluate(int left, string right);
        }

        private class AddCommand : ICommand
        {
            public int Evaluate(int left, string right)
            {
                return left + Solver.Resolve(right);
            }
        }

        private class SubstractionCommand : ICommand
        {
            public int Evaluate(int left, string right)
            {
                return left - Solver.Resolve(right);
            }
        }

        private class ProductCommand : ICommand
        {
            public int Evaluate(int left, string right)
            {
                return left*Solver.Resolve(right);
            }
        }
    }
}