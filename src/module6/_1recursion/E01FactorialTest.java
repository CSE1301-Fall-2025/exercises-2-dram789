package module6._1recursion;

/*
 * Exercise: Use the debugger to examine how this recursive method works.
 * Add examples for the factorial of 4 and the factorial of 1.
 */
public class E01FactorialTest {

	public static int factorial(int n) {
		if (n == 0) { // base case
			return 1;
		} else { // recursive call
			return n * factorial(n - 1);
		}
	}

	// same method as factorial but uses while loop instead of recursion
	public static int factorialLoop(int n) {
		int result = 1;
		while (n != 0) {
			result = result * n;
			n--;
		}
		return result;
	}

	// 4! = 4 * 3 * 2 * 1 = 24
	// 4! = 4 * 3!
	// n! = n * (n-1)!

	// *SUBSTITUTION METHOD*/

	// factorial(4) = 4 * factorial(3)
	// factorial(3) = 3 * factorial(2)
	// factorial(2) = 2 * factorial(1)
	// factorial(1) = 1 * factorial(0)
	// factorial(0) = 1 (satisfies our base case, hits "return 1" line of code)
	// factorial(1) = 1 * 1 = 1 now go through and substitute the values above
	// factorial(2) = 2 * 1 = 2
	// factorial(3) = 3 * 2 = 6
	// factorial(4) = 4 * 6 = 24

	public static void main(String[] args) {
		System.out.println(factorial(4));
	}
}
