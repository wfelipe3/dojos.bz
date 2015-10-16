using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace quicksort
{
    public class QuickSort
    {

        public static int[] Sort(int[] actual)
        {
            if (actual.Length == 2)
            {
                if (actual[0] > actual[1])
                {
                    return new int[] {actual[1], actual[0]};
                }
            }
            else if(actual.Length>2)
            {
                List<int> values = new List<int>();
                List<int> rigth = new List<int>();
                List<int> left = new List<int>();

                int pivot = 1;
                for (int i=0;i<actual.Length;i++)
                {
                    if (i!=pivot)
                    {
                        if (actual[i] > actual[pivot])
                        {
                            rigth.Add(actual[i]);
                        }
                        else
                        {
                            left.Add(actual[i]);
                        }
                    }
                }

                
                values.AddRange(Sort(left.ToArray()));
                values.Add(actual[pivot]);
                values.AddRange(Sort(rigth.ToArray()));
                return values.ToArray();
            }
            return actual;
        }

    }
}
