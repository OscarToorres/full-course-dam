package misClases.avaliacion2;

import misClases.teoria.Leer;

public class CMatrices
{
    private int[][] A;
    private int[][] B;
    private int[][] C;
    private int[][] D;
    private int n;
    
    public CMatrices() {
        this.A = new int[3][3];
        this.B = new int[3][3];
        this.C = new int[3][3];
        this.D = new int[3][3];
        this.n = 3;
    }
    
    private int[][] dameReferencia(final char letra) {
        int[][] M = null;
        if (letra == 'A' || letra == 'a') {
            M = this.A;
        }
        else if (letra == 'B' || letra == 'b') {
            M = this.B;
        }
        else if (letra == 'C' || letra == 'c') {
            M = this.C;
        }
        else if (letra == 'D' || letra == 'd') {
            M = this.D;
        }
        return M;
    }
    
    public void recolle() {
        System.out.print("Introduce dimension(2 o 3):     ");
        this.n = Leer.datoInt();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                System.out.print("A[" + i + "][" + j + "]:");
                this.A[i][j] = Leer.datoInt();
            }
        }
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                System.out.print("B[" + i + "][" + j + "]:");
                this.B[i][j] = Leer.datoInt();
            }
        }
    }
    
    public void amosa(final char una, final char dos) {
        final int[][] M1 = this.dameReferencia(una);
        final int[][] M2 = this.dameReferencia(dos);
        System.out.println();
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                if (M1[i][j] < 0 || M1[i][j] > 9) {
                    System.out.print("    " + M1[i][j]);
                }
                else {
                    System.out.print("     " + M1[i][j]);
                }
            }
            System.out.print("     ");
            for (int j = 0; j < this.n; ++j) {
                if (M2[i][j] < 0 || M2[i][j] > 9) {
                    System.out.print("    " + M2[i][j]);
                }
                else {
                    System.out.print("     " + M2[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void trasposta(final char una, final char dos) {
        final int[][] M1 = this.dameReferencia(una);
        final int[][] M2 = this.dameReferencia(dos);
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                M2[i][j] = M1[j][i];
            }
        }
    }
    
    public void suma(final char una, final char dos, final char tres) {
        final int[][] M1 = this.dameReferencia(una);
        final int[][] M2 = this.dameReferencia(dos);
        final int[][] M3 = this.dameReferencia(tres);
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                M3[i][j] = M1[i][j] + M2[i][j];
            }
        }
    }
    
    public void resta(final char una, final char dos, final char tres) {
        final int[][] M1 = this.dameReferencia(una);
        final int[][] M2 = this.dameReferencia(dos);
        final int[][] M3 = this.dameReferencia(tres);
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                M3[i][j] = M1[i][j] - M2[i][j];
            }
        }
    }
    
    public void multiplica(final char una, final char dos, final char tres) {
        final int[][] M1 = this.dameReferencia(una);
        final int[][] M2 = this.dameReferencia(dos);
        final int[][] M3 = this.dameReferencia(tres);
        for (int i = 0; i < this.n; ++i) {
            for (int j = 0; j < this.n; ++j) {
                M3[i][j] = 0;
                for (int k = 0; k < this.n; ++k) {
                    M3[i][j] += M1[i][k] * M2[k][j];
                }
            }
        }
    }
}