package org.pascal.triangle;

import lombok.Getter;

import java.util.Arrays;
import java.util.LinkedList;

public class Row {

    @Getter
    private final LinkedList<Integer> numbers;

    public Row(Integer... numbers) {
        this.numbers = new LinkedList<>(Arrays.asList(numbers));
    }

    public Row(Row previousRow) {
        numbers = generateNumbers(generateInputList(previousRow.getNumbers()));
    }

    private LinkedList<Integer> generateInputList(LinkedList<Integer> numbers) {
        LinkedList<Integer> inputList = new LinkedList<>(numbers);
        inputList.addFirst(0);
        inputList.addLast(0);
        return inputList;
    }

    private LinkedList<Integer> generateNumbers(LinkedList<Integer> inputList) {
        LinkedList<Integer> numbers = new LinkedList<>();
        while (inputList.size() > 1) {
            numbers.add(inputList.pollFirst() + inputList.peekFirst());
        }
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder rowBuilder = new StringBuilder();
        numbers.forEach(nu -> rowBuilder.append(nu).append(" "));
        rowBuilder.setLength(Math.max(rowBuilder.length() - 1, 0));
        return rowBuilder.toString();
    }

}
