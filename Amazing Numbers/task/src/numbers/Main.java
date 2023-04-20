package numbers;

import java.util.Arrays;
import java.util.Scanner;

class Number {
    String value;
    boolean even;
    boolean odd;
    boolean buzz;
    boolean duck;
    boolean gapful;
    boolean palindromic;
    boolean spy;
    boolean sunny;
    boolean square;
    boolean jumping;


    public Number(String input) {
        this.value = input;
        checkParity(input);
        checkBuzzingNumber(input);
        checkDuckNumber(input);
        checkPalindromic(input);
        checkGapful(input);
        checkSpy(input);
        checkSunny(input);
        checkSquare(input);
        checkJumping(input);

    }


    private void checkParity(String input) {
        Long inputInt = Long.parseLong(input);
        if (inputInt % 2 == 0) {
            this.even = true;
            this.odd = false;
        } else {
            this.even = false;
            this.odd = true;
        }
    }

    private void checkBuzzingNumber(String input) {
        Long inputInt = Long.parseLong(input);
        if (inputInt % 7 == 0 && inputInt % 10 == 7) {
            this.buzz = true;
        } else if (inputInt % 7 == 0) {
            this.buzz = true;
        } else this.buzz = inputInt % 10 == 7;
    }

    private void checkDuckNumber(String input) {
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == '0') {
                this.duck = true;
                break;
            }
            this.duck = false;

        }
    }

    private void checkPalindromic(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                this.palindromic = false;
                break;
            } else this.palindromic = true;

        }
    }

    private void checkGapful(String input) {
        if (input.length() >= 3) {
            String inputFirstLastDigit = Character.toString(input.charAt(0)) + Character.toString(input.charAt(input.length() - 1));
            int inputFirstLastDigitInt = Integer.parseInt(inputFirstLastDigit);
            Long inputInt = Long.parseLong(input);
            this.gapful = inputInt % inputFirstLastDigitInt == 0;

        } else this.gapful = false;
    }

    private void checkSpy(String input) {
        int sumOfDigits = 0;
        int productOfDigits = 1;
        for (int i = 0; i < input.length(); i++) {
            sumOfDigits += Character.getNumericValue(input.charAt(i));
            productOfDigits *= Character.getNumericValue(input.charAt(i));
        }
        this.spy = sumOfDigits == productOfDigits;

    }

    private void checkSunny(String input) {
        Long inputInt = Long.parseLong(input) + 1;
        double sqrt = Math.sqrt(inputInt);
        this.sunny = (sqrt - Math.floor(sqrt) == 0);

    }

    private void checkSquare(String input) {
        Long inputInt = Long.parseLong(input);
        double sqrt = Math.sqrt(inputInt);
        this.square = (sqrt - Math.floor(sqrt) == 0);
    }

    private void checkJumping(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.getNumericValue(input.charAt(i)) == Character.getNumericValue(input.charAt(i + 1)) - 1
                    || Character.getNumericValue(input.charAt(i)) == Character.getNumericValue(input.charAt(i + 1)) + 1) {
                this.square = true;
            } else {
                this.square = false;
                break;
            }


        }

    }

    class Input {
        String firstNum;
        String secondNum;
        String argOne;
        String argTwo;
        String[] propertyList = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SUNNY", "SQUARE"};

        int numOfArguments;
        int optionNum;
        String[] argumentList;


        public Input() {
            System.out.println("Enter a request:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            this.numOfArguments = inputArr.length;
            if (inputArr.length >= 1) {
                this.optionNum = generateOptionNum(inputArr[0]);
                this.firstNum = inputArr[0];
            }
            if (inputArr.length >= 2) {
                this.optionNum = generateOptionNum(inputArr[0], inputArr[1]);
                this.secondNum = inputArr[1];
            }
            if (inputArr.length >= 3) {
                inputArr[2] = inputArr[2].toUpperCase();
                this.optionNum = generateOptionNum(inputArr[0], inputArr[1], inputArr[2]);
                this.argOne = inputArr[2];
            }
            if (inputArr.length >= 4) {
                inputArr[3] = inputArr[3].toUpperCase();
                this.argTwo = inputArr[3];
                this.optionNum = generateOptionNum(inputArr[0], inputArr[1], inputArr[2], inputArr[3]);
            }if (inputArr.length > 4) {
                for (int i = 2; i < inputArr.length; i++) {
                    this.argumentList[i -2] = inputArr[i];
                }
            }
        }

        int generateOptionNum(String input1) {
            Long inputInt = Long.parseLong(input1);
            if (inputInt == 0) {
                return 0;
            } else if (inputInt < 0) {
                return 5;
            } else {
                return 1;
            }

        }

        int generateOptionNum(String input1, String input2) {
            Long inputInt = Long.parseLong(input1);
            Long inputInt2 = Long.parseLong(input2);
            if (inputInt == 0) {
                return 0;
            } else if (inputInt < 0) {
                return 5;
            } else if (inputInt2 == 0) {
                return 1;
            } else if (inputInt2 < 0) {
                return 6;
            } else {
                return 2;
            }
        }

        int generateOptionNum(String input1, String input2, String arg1) {
            Long inputInt = Long.parseLong(input1);
            Long inputInt2 = Long.parseLong(input2);
            if (inputInt == 0) {
                return 0;
            } else if (inputInt < 0) {
                return 5;
            } else if (inputInt2 == 0) {
                return 1;
            } else if (inputInt2 < 0) {
                return 6;
            } else if (!checkPropertyList(arg1)) {
                return 7;
            } else {
                return 3;
            }

        }

        int generateOptionNum(String input1, String input2, String arg1, String arg2) {
            Long inputInt = Long.parseLong(input1);
            Long inputInt2 = Long.parseLong(input2);
            if (inputInt == 0) {
                return 0;
            } else if (inputInt < 0) {
                return 5;
            } else if (inputInt2 == 0) {
                return 1;
            } else if (inputInt2 < 0) {
                return 6;
            } else if (checkMutuallyExclusive(arg1, arg2)) {
                return 10;
            } else if (checkPropertyList(arg1) && checkPropertyList(arg2)) {
                return 4;
            } else if (!checkPropertyList(arg1) && !checkPropertyList(arg2)) {
                return 9;
            } else if (!checkPropertyList(arg1)) {
                return 7;
            } else if (!checkPropertyList(arg2)) {
                return 8;
            } else {
                return 99;
            }
        }

        boolean checkPropertyList(String input) {
            return Arrays.asList(this.propertyList).contains(input);
        }

        boolean checkMutuallyExclusive(String input1, String input2) {
            if (input1.equals("ODD") && input2.equals("EVEN") || input1.equals("EVEN") && input2.equals("ODD")) {
                return true;
            } else if (input1.equals("SUNNY") && input2.equals("SQUARE") || input1.equals("SQUARE") && input2.equals("SUNNY")) {
                return true;
            } else if (input1.equals("DUCK") && input2.equals("SPY") || input1.equals("SPY") && input2.equals("DUCK")) {
                return true;
            } else {
                return false;
            }

        }
    }


    public class Main {
        public static void main(String[] args) {
            boolean programRun = true;

            welcomeUser();
            do {
                Input input = new Input();
                switch (input.optionNum) {
                    case 0 -> {
                        System.out.println("Goodbye!");
                        programRun = false;
                    }
                    case 1 -> printOutput(input.firstNum);
                    case 2 -> printOutput(input.firstNum, input.secondNum);
                    case 3 -> printOutput(input.firstNum, input.secondNum, input.argOne);
                    case 4 -> printOutput(input.firstNum, input.secondNum, input.argOne, input.argTwo);
                    case 5 -> System.out.println("The first parameter should be a natural number or zero.");
                    case 6 -> System.out.println("The second parameter should be a natural number.");
                    case 7 -> {
                        System.out.println("The property [" + input.argOne + "] is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]");
                    }
                    case 8 -> {
                        System.out.println("The property [" + input.argTwo + "] is wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]");
                    }
                    case 9 -> {
                        System.out.println("The properties [" + input.argTwo + "," + input.argTwo + "] are wrong.");
                        System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SUNNY, SQUARE]");
                    }
                    case 10 -> {
                        System.out.println("The request contains mutually exclusive properties: [" + input.argOne + ", " + input.argTwo + "]");
                    }
                    default -> {
                        System.out.println("Error");
                        programRun = false;
                    }
                }
            } while (programRun);
        }

        private static void welcomeUser() {
            System.out.println("""
                    Welcome to Amazing Numbers!
                                    
                    Supported requests:
                    - enter a natural number to know its properties;
                    - enter two natural numbers to obtain the properties of the list:
                      * the first parameter represents a starting number;
                      * the second parameter shows how many consecutive numbers are to be printed;
                    - two natural numbers and two properties to search for;
                    - separate the parameters with one space;
                    - enter 0 to exit.       \s
                    """);
        }

        private static void printOutput(String input) {
            Number number = new Number(input);
            System.out.println("Properties of " + number.value);
            System.out.println("       even: " + number.even);
            System.out.println("        odd: " + number.odd);
            System.out.println("       buzz: " + number.buzz);
            System.out.println("       duck: " + number.duck);
            System.out.println("palindromic: " + number.palindromic);
            System.out.println("     gapful: " + number.gapful);
            System.out.println("        spy: " + number.spy);
            System.out.println("      sunny: " + number.sunny);
            System.out.println("     square: " + number.square);


        }

        private static void printOutput(String input1, String input2) {
            Long input2Int = Long.parseLong(input2);
            for (int i = 0; i < input2Int; i++) {
                Long input1Long = Long.parseUnsignedLong(input1);
                input1Long += i;
                String input1Str = Long.toString(input1Long);
                Number number = new Number(input1Str);
                outputPrinter(number);
            }
        }

        private static void outputPrinter(Number number) {
            System.out.print(number.value + " is ");
            if (number.even) System.out.print("even ");
            if (number.odd) System.out.print("odd ");
            if (number.buzz) System.out.print("buzz ");
            if (number.duck) System.out.print("duck ");
            if (number.palindromic) System.out.print("palindromic ");
            if (number.gapful) System.out.print("gapful ");
            if (number.spy) System.out.print("spy ");
            if (number.square) System.out.print("square ");
            if (number.sunny) System.out.print("sunny ");
            System.out.println();
        }

        private static void printOutput(String input1, String input2, String input3) {

            Long input2Int = Long.parseLong(input2);
            int count = 0;
            while (count < input2Int) {
                Number number = new Number(input1);
                Long input1Long = Long.parseUnsignedLong(input1);
                input1Long++;
                input1 = Long.toString(input1Long);
                switch (input3) {
                    case "EVEN" -> {
                        if (number.even) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "ODD" -> {
                        if (number.odd) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "BUZZ" -> {
                        if (number.buzz) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "DUCK" -> {
                        if (number.duck) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "PALINDROMIC" -> {
                        if (number.palindromic) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "GAPFUL" -> {
                        if (number.gapful) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "SPY" -> {
                        if (number.spy) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "SUNNY" -> {
                        if (number.sunny) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    case "SQUARE" -> {
                        if (number.square) {
                            outputPrinter(number);
                            count++;
                        }
                    }
                    default -> System.out.println("error output");
                }
            }
        }

        private static void printOutput(String input1, String input2, String input3, String input4) {
            Long input2Int = Long.parseLong(input2);
            int count = 0;
            while (count < input2Int) {
                Number number = new Number(input1);
                Long input1Long = Long.parseUnsignedLong(input1);
                input1Long++;
                input1 = Long.toString(input1Long);
                count = count + searchWithoutCount(input3, input4, number);
            }
        }

        private static int searchWithoutCount(String input1, String input2, Number number) {
            int val = 0;
            switch (input1) {
                case "EVEN" -> {
                    if (number.even) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "ODD" -> {
                    if (number.odd) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "BUZZ" -> {
                    if (number.buzz) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "DUCK" -> {
                    if (number.duck) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "PALINDROMIC" -> {
                    if (number.palindromic) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "GAPFUL" -> {
                    if (number.gapful) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "SPY" -> {
                    if (number.spy) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "SUNNY" -> {
                    if (number.sunny) {
                        val = searchWithCount(input2, number);
                    }
                }
                case "SQUARE" -> {
                    if (number.square) {
                        val = searchWithCount(input2, number);
                    }
                }
                default -> {
                    System.out.println("error output");
                    return 0;
                }
            }
            return val;
        }

        private static int searchWithCount(String input, Number number) {
            switch (input) {
                case "EVEN" -> {
                    if (number.even) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "ODD" -> {
                    if (number.odd) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "BUZZ" -> {
                    if (number.buzz) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "DUCK" -> {
                    if (number.duck) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "PALINDROMIC" -> {
                    if (number.palindromic) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "GAPFUL" -> {
                    if (number.gapful) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "SPY" -> {
                    if (number.spy) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "SUNNY" -> {
                    if (number.sunny) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                case "SQUARE" -> {
                    if (number.square) {
                        outputPrinter(number);
                        return 1;
                    }
                }
                default -> {
                    System.out.println("error");
                    return 0;
                }
            }
            return 0;
        }
    }
