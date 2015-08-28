using System;
using System.CodeDom;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace RomanNumerals
{
    public class RomanConverter
    {
        private Dictionary<int, string> _romanConstants;

        static void Main(string[] args)
        {
        }

        public RomanConverter()
        {
            _romanConstants = new Dictionary<int, string>();
            _romanConstants.Add(1, "I");
            _romanConstants.Add(5, "V");
            _romanConstants.Add(10, "X");
            _romanConstants.Add(50, "L");
            _romanConstants.Add(100, "C");
            _romanConstants.Add(500, "D");
            _romanConstants.Add(1000, "M");
        }

        public string ConvertToRoman(int inputNumber)
        {
            
            if (_romanConstants.ContainsKey(inputNumber))
                return _romanConstants[inputNumber];
            else
            {
                if (inputNumber>89)
                {
                    return "XC";
                }

                if (inputNumber > 10)
                {
                    return "X" + ConvertToRoman(inputNumber - 10);
                }
                if (inputNumber > 8)
                    return "IX";
                if (inputNumber > 5)
                {
                    return "V" + ConvertToRoman(inputNumber % 5);
                }


                if (inputNumber > 3)
                    return "IV";
                return FromItoIII(inputNumber);
            }
        }

        private static string FromItoIII(int inputNumber)
        {
            string result = "";
            for (int i = 0; i < inputNumber; i++)
            {
                result += "I";
            }
            return result;
        }
    }
}
