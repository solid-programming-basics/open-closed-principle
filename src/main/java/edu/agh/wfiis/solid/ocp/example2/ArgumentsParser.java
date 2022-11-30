package edu.agh.wfiis.solid.ocp.example2;

class ArgumentsParser {

    static Arguments parse(String[] args) {

        Arguments arguments = new Arguments();

        arguments.first = Integer.valueOf(args[0]);
        arguments.second = Integer.valueOf(args[2]);
        arguments.operator = args[1];

        return arguments;
    }
}