import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Solution {

	public List<ExceptionProxy> transformException(List<Supplier<?>> functions) {
		List<ExceptionProxy> proxies = new ArrayList<>();
		
		for (Supplier<?> function : functions) {
			try {
				function.get();
				
				proxies.add(new ExceptionProxy(function));
			} catch (Exception e) {
				proxies.add(new ExceptionProxy(e, function));
			}
		}

		return proxies;
	}

	public static class ExceptionProxy {
		String msg;
		Supplier<?> function;

		public ExceptionProxy(Supplier<?> function) {
			this.msg = "OK!";
			this.function = function;
		}
		public ExceptionProxy(Exception e, Supplier<?> function) {
			this.msg = e.getMessage();
			this.function = function;
		}

		public String getMsg() {
			return msg;
		}

		public Supplier<?> getFunction() {
			return function;
		}
	}
	
	public static void main(String[] args) {
		List<Supplier<?>> functions = Arrays.asList(new Devider(1,0), new Devider(1,1));
		
		Solution solution = new Solution();
		List<Solution.ExceptionProxy> result = solution.transformException(functions);
		for(Solution.ExceptionProxy exceptionProxy: result) {
			System.out.println("msg: " + exceptionProxy.getMsg());
			System.out.println("function: " + exceptionProxy.getFunction());
		}
	}
	
	public static class Devider implements Supplier<Integer> {
		int x, y;
		public Devider(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public Integer get() {
			return x / y;
		}
		@Override
		public String toString() {
			return "Devide[" + x + "/" + y + "]";
		}
	}
}
