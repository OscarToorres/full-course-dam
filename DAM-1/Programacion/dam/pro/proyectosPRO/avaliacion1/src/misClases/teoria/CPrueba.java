package misClases.teoria;

public class CPrueba {

		@SuppressWarnings("unused")
		private float grados;
		
		public void RecogeGrados(float a) {
			grados = a;
		}
		
		public void AmosaGrados(float a) {
			grados = a;
			System.out.println(a + " C " + (9F/5F * a + 32) + " F");
		}
}