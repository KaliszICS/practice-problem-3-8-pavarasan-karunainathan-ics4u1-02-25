public class PracticeProblem{
	static int min(int a, int b){
		return a < b ? a : b;
	}

	static int[] globalCost;
	static int[] reference;

	static int fibonacciHelper(int n){
		if(n == 0) return 0;
		else if(n == 1) return 1;
		if(reference[n] != 0) return reference[n];
		return reference[n] = fibonacciHelper(n-1) + fibonacciHelper(n-2);
	}

	static int fib(int num){
		reference = new int[num+1];
		return fibonacciHelper(num);
	}

	static int costHelper(int x){
		if(x >= globalCost.length){
			return 0;
		}
		if(reference[x] != 0) return reference[x];
		
		return reference[x] = min(costHelper(x+1), costHelper(x+2)) + globalCost[x];
	}

	static int minCostClimbingStairs(int[] cost){
		globalCost = cost;
		reference = new int[globalCost.length];
		return cost.length == 1 ? cost[0] : min(costHelper(0), costHelper(1));
	}


	public static void main(String args[]){}
}
