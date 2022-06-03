package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();
        for (int i=0; i<DMatrix.length;i++){
            DMatrix[i]= DMatrix[i].clone();
        }

        for (int k = 0; k< getAantalKnopen();k++){
            for (int i=0;i<getAantalKnopen();i++){
                for (int j = 0; j<getAantalKnopen();j++){
                 if (DMatrix[i][k]+DMatrix[k][j]<DMatrix[i][j]){
                     DMatrix[i][j]=DMatrix[i][k]+DMatrix[k][j];
                     pointerMatrix[i][j]=k+1;
                 }
                }
            }
        }
		return pointerMatrix;
	}

	public List<Integer> getShortestPath(int van, int tot, int[][] P) {
        List<Integer> pad = new ArrayList<>();
        if (van == tot) {
            return pad;
        } else {
            int via = P[van - 1][tot - 1];
            if (via == 0){
                pad.add(van);
                pad.add(tot);
            } else {
                pad = getShortestPath(van, via, P);
                pad.remove(pad.size() - 1); //anders dubbel
                pad.addAll(getShortestPath(via, tot, P));
            }
        }

        return pad;
	}

	public int berekenLengte(List<Integer> pad) {
        int som = 0;
        int aantalKnopen = pad.size();
        int huidigeKnoop, volgendeKnoop;

        for (int i = 0; i < aantalKnopen - 1; i++) {
            huidigeKnoop = pad.get(i);
            volgendeKnoop = pad.get(i + 1);
            som += this.gewichtenMatrix[huidigeKnoop - 1][volgendeKnoop - 1];
        }
		return som;
	}

}
