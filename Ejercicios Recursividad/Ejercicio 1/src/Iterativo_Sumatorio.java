public class Iterativo_Sumatorio {
        public static int Sumatorio(int n) {

            int f = 1;

            for (int i = 1; i <= n; i++) {
                f = f + i;
            }

            return f;
        }
}
