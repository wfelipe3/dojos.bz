using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ATM
{
    public static class ATM
    {
        public static List<int> Bills = new List<int>(){1, 2, 5, 10, 20, 50};

        public static Dictionary<int, int> GetEmptyDictionary() 
        {
            return new Dictionary<int, int>()
            {
                {1,0},
                {2,0},
                {5,0},
                {10,0},
                {20,0},
                {50,0}
            };
        }
        
        public static Dictionary<int, int> Money(int value, Dictionary<int, int> dictionary=null)
        {
            
            if (dictionary == null)
            {
                dictionary = GetEmptyDictionary();
            }

            if (value == 0)
            {
                return dictionary;
            }
            else
            {
                var max = dictionary.Keys.Where(x => x <= value).Max();
                dictionary[max] = dictionary[max] + 1;
                return Money(value - max, dictionary);
            }
        }
    }
}
