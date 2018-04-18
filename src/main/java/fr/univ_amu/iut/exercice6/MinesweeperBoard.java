package fr.univ_amu.iut.exercice6;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperBoard {
    List<String> list;
    //List<String> annotationRepresentation;
    char[][] inputMatrix;
    int[][] annotationMatrix;

    public MinesweeperBoard(List<String> inputBoard) {
        list = inputBoard;
        //this.annotationRepresentation = new ArrayList<>();
        if (list.size() != 0){
            int hauteur = getHauteur();
            int largeur = getLargeur();
            inputMatrix = new char[largeur+2][hauteur+2];
            remplirList(inputBoard);
        }
        //annotationMatrix = new int[largeur+2][hauteur+2];
    };

    public List<String> getAnnotatedRepresentation() {
        return list;
    }

    private int getHauteur(){
        return list.size();
    }
    private int getLargeur(){
        return list.get(0).length();
    }
    private List<String> remplirList(List<String> list){
        for (int i = 0; i < getLargeur() + 2; ++i)
            for (int j = 0; j < getLargeur() + 2 ; ++j)
            {
                if (i != 0 && j != 0 && j != getLargeur()+1) {
                    inputMatrix[i][j] = list.get(i - 1).charAt(j - 1);
                }
                if (inputMatrix[i][j] == ' ')
                    inputMatrix[i][j] = comptageDeMine(inputMatrix, i, j);
                System.out.println(inputMatrix[i][j]);

            }
            return list;
    }

    private char comptageDeMine(char[][] inputMatrix, int i, int j){
        int nombreMine = 0;
        if (inputMatrix[i -1][j-1] == '*')
            ++nombreMine;
        if (inputMatrix[i -1][j] == '*')
            ++nombreMine;
        if (inputMatrix[i -1][j+1] == '*')
            ++nombreMine;
        if (inputMatrix[i][j-1] == '*')
            ++nombreMine;

        if (inputMatrix[i][j+1] == '*')
            ++nombreMine;
        if (inputMatrix[i +1][j-1] == '*')
            ++nombreMine;
        if (inputMatrix[i +1][j] == '*')
            ++nombreMine;
        if (inputMatrix[i +1][j+1] == '*')
            ++nombreMine;

        String s = ""+nombreMine;
        return s.charAt(0);
    }
}
