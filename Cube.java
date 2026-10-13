public class Cube {
    private char[][] cubeColors;

    public Cube() {
        this.cubeColors = new char[6][9];
        char[] colors = {'W', 'R', 'B', 'O', 'G', 'Y'};
        int nextColor = 0;
        for(int i = 0; i < this.cubeColors.length; i++) {
            for(int j = 0; j < this.cubeColors[i].length; j++) {
                this.cubeColors[i][j] = colors[nextColor];
            }
            nextColor++;
        }
        // this.cubeColors[1][0] = 'A';
        // this.cubeColors[1][1] = 'B';
        // this.cubeColors[1][2] = 'C';
        // this.cubeColors[1][3] = 'D';
        // this.cubeColors[1][4] = 'E';
        // this.cubeColors[1][5] = 'F';
        // this.cubeColors[1][6] = 'G';
        // this.cubeColors[1][7] = 'H';
        // this.cubeColors[1][8] = 'I';
        // this.cubeColors[4][0] = 'J';
        // this.cubeColors[4][1] = 'K';
        // this.cubeColors[4][2] = 'L';
    }

    public String getColor(char charColor) {
        switch(charColor) {
            case 'W':
                return "\u001B[0m";
            case 'R':
                return "\u001B[31m";
            case 'B':
                return "\u001B[38;5;21m";
            case 'O':
                return "\u001B[38;5;208m";
            case 'G':
                return "\u001B[32m";
            default: 
                return "\u001B[33m";
        }
    }

    public void scramble() {
        for(int i = 0; i < 30; i++) {
            int rand = (int)(Math.random() * 12);
            switch(rand) {
                case 0:
                    moveU();
                    break;
                case 1:
                    moveUPrime();
                    break;
                case 2:
                    moveL();
                    break;
                case 3:
                    moveLPrime();
                    break;
                case 4:
                    moveF();
                    break;
                case 5:
                    moveFPrime();
                    break;
                case 6:
                    moveR();
                    break;
                case 7:
                    moveRPrime();
                    break;
                case 8:
                    moveB();
                    break;
                case 9:
                    moveBPrime();
                    break;
                case 10:
                    moveD();
                    break;
                case 11:
                    moveDPrime();
                    break;
            }
        }
    }

    public String getSide(int sideNumber) {
        String result = "";
        int count = 0;
        for(char color : cubeColors[sideNumber]) {
            result += color;
            count++;
            if(count == 3) {
                count = 0;
                result += "\n";
            }
            else {
                result += " ";
            }
        }
        return result.strip();
    }

    public void rotateSideFace(int sideNumber) {
        char tempColor = this.cubeColors[sideNumber][0];
        this.cubeColors[sideNumber][0] = this.cubeColors[sideNumber][6];
        this.cubeColors[sideNumber][6] = this.cubeColors[sideNumber][8];
        this.cubeColors[sideNumber][8] = this.cubeColors[sideNumber][2];
        this.cubeColors[sideNumber][2] = tempColor;

        tempColor = this.cubeColors[sideNumber][1];
        this.cubeColors[sideNumber][1] = this.cubeColors[sideNumber][3];
        this.cubeColors[sideNumber][3] = this.cubeColors[sideNumber][7];
        this.cubeColors[sideNumber][7] = this.cubeColors[sideNumber][5];
        this.cubeColors[sideNumber][5] = tempColor;
    }

    public void moveU() {
        rotateSideFace(0);
        char temp1 = this.cubeColors[1][0];
        char temp2 = this.cubeColors[1][1];
        char temp3 = this.cubeColors[1][2];
        this.cubeColors[1][0] = this.cubeColors[2][0];
        this.cubeColors[1][1] = this.cubeColors[2][1];
        this.cubeColors[1][2] = this.cubeColors[2][2];
        this.cubeColors[2][0] = this.cubeColors[3][0];
        this.cubeColors[2][1] = this.cubeColors[3][1];
        this.cubeColors[2][2] = this.cubeColors[3][2];
        this.cubeColors[3][0] = this.cubeColors[4][0];
        this.cubeColors[3][1] = this.cubeColors[4][1];
        this.cubeColors[3][2] = this.cubeColors[4][2];
        this.cubeColors[4][0] = temp1;
        this.cubeColors[4][1] = temp2;
        this.cubeColors[4][2] = temp3;
    }

    public void moveUPrime() {
        moveU();
        moveU();
        moveU();
    }

    public void moveL() {
        rotateSideFace(1);
        char temp1 = this.cubeColors[0][0];
        char temp2 = this.cubeColors[0][3];
        char temp3 = this.cubeColors[0][6];
        this.cubeColors[0][0] = this.cubeColors[4][8];
        this.cubeColors[0][3] = this.cubeColors[4][5];
        this.cubeColors[0][6] = this.cubeColors[4][2];
        this.cubeColors[4][8] = this.cubeColors[5][0];
        this.cubeColors[4][5] = this.cubeColors[5][3];
        this.cubeColors[4][2] = this.cubeColors[5][6];
        this.cubeColors[5][0] = this.cubeColors[2][0];
        this.cubeColors[5][3] = this.cubeColors[2][3];
        this.cubeColors[5][6] = this.cubeColors[2][6];
        this.cubeColors[2][0] = temp1;
        this.cubeColors[2][3] = temp2;
        this.cubeColors[2][6] = temp3;
    }

    public void moveLPrime() {
        moveL();
        moveL();
        moveL();
    }

    public void moveF() {
        rotateSideFace(2);
        char temp1 = this.cubeColors[0][6];
        char temp2 = this.cubeColors[0][7];
        char temp3 = this.cubeColors[0][8];
        this.cubeColors[0][6] = this.cubeColors[1][8];
        this.cubeColors[0][7] = this.cubeColors[1][5];
        this.cubeColors[0][8] = this.cubeColors[1][2];
        this.cubeColors[1][8] = this.cubeColors[5][2];
        this.cubeColors[1][5] = this.cubeColors[5][1];
        this.cubeColors[1][2] = this.cubeColors[5][0];
        this.cubeColors[5][2] = this.cubeColors[3][0];
        this.cubeColors[5][1] = this.cubeColors[3][3];
        this.cubeColors[5][0] = this.cubeColors[3][6];
        this.cubeColors[3][6] = temp3;
        this.cubeColors[3][3] = temp2;
        this.cubeColors[3][0] = temp1;
    }

    public void moveFPrime() {
        moveF();
        moveF();
        moveF();
    }

    public void moveR() {
        rotateSideFace(3);
        char temp1 = this.cubeColors[0][2];
        char temp2 = this.cubeColors[0][5];
        char temp3 = this.cubeColors[0][8];
        this.cubeColors[0][2] = this.cubeColors[2][2];
        this.cubeColors[0][5] = this.cubeColors[2][5];
        this.cubeColors[0][8] = this.cubeColors[2][8];
        this.cubeColors[2][2] = this.cubeColors[5][2];
        this.cubeColors[2][5] = this.cubeColors[5][5];
        this.cubeColors[2][8] = this.cubeColors[5][8];
        this.cubeColors[5][2] = this.cubeColors[4][6];
        this.cubeColors[5][5] = this.cubeColors[4][3];
        this.cubeColors[5][8] = this.cubeColors[4][0];
        this.cubeColors[4][6] = temp1;
        this.cubeColors[4][3] = temp2;
        this.cubeColors[4][0] = temp3;
    }

    public void moveRPrime() {
        moveR();
        moveR();
        moveR();
    }

    public void moveB() {
        rotateSideFace(4);
        char temp1 = this.cubeColors[0][0];
        char temp2 = this.cubeColors[0][1];
        char temp3 = this.cubeColors[0][2];
        this.cubeColors[0][0] = this.cubeColors[3][2];
        this.cubeColors[0][1] = this.cubeColors[3][5];
        this.cubeColors[0][2] = this.cubeColors[3][8];
        this.cubeColors[3][2] = this.cubeColors[5][8];
        this.cubeColors[3][5] = this.cubeColors[5][7];
        this.cubeColors[3][8] = this.cubeColors[5][6];
        this.cubeColors[5][8] = this.cubeColors[1][6];
        this.cubeColors[5][7] = this.cubeColors[1][3];
        this.cubeColors[5][6] = this.cubeColors[1][0];
        this.cubeColors[1][6] = temp1;
        this.cubeColors[1][3] = temp2;
        this.cubeColors[1][0] = temp3;
    }

    public void moveBPrime() {
        moveB();
        moveB();
        moveB();
    }

    public void moveD() {
        rotateSideFace(5);
        char temp1 = this.cubeColors[2][6];
        char temp2 = this.cubeColors[2][7];
        char temp3 = this.cubeColors[2][8];
        this.cubeColors[2][6] = this.cubeColors[1][6];
        this.cubeColors[2][7] = this.cubeColors[1][7];
        this.cubeColors[2][8] = this.cubeColors[1][8];
        this.cubeColors[1][6] = this.cubeColors[4][6];
        this.cubeColors[1][7] = this.cubeColors[4][7];
        this.cubeColors[1][8] = this.cubeColors[4][8];
        this.cubeColors[4][6] = this.cubeColors[3][6];
        this.cubeColors[4][7] = this.cubeColors[3][7];
        this.cubeColors[4][8] = this.cubeColors[3][8];
        this.cubeColors[3][6] = temp1;
        this.cubeColors[3][7] = temp2;
        this.cubeColors[3][8] = temp3;
    }

    public void moveDPrime() {
        moveD();
        moveD();
        moveD();
    }

    @Override
    public String toString() {
        String result = "      ";
        int count = 0;
        //top side
        for(char color : this.cubeColors[0]) {
            result += getColor(color) + color;
            count++;
            if(count == 3) {
                count = 0;
                result += "\n      ";
            }
            else {
                result += " ";
            }
        }
        result = result.stripTrailing();
        result += "\n";

        //middle sides
        for(int i = 0; i < 3; i++) {
            for(int j = 1; j < 5; j++) {
                for(int k = 0; k < 3; k++) {
                    result += getColor(this.cubeColors[j][3 * i + k]) + this.cubeColors[j][3 * i + k] + " ";
                }
            }
            result = result.stripTrailing();
            result += "\n";
        }
        
        
        //top side
        result += "      ";
        for(char color : this.cubeColors[5]) {
            result += getColor(color) + color;
            count++;
            if(count == 3) {
                count = 0;
                result += "\n      ";
            }
            else {
                result += " ";
            }
        }
        return result.stripTrailing() + "\u001B[0m";
    }
}
