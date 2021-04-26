package org.pascal.triangle;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TriangleGenerator {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.print("Please enter depth of Pascal's triangle: ");
        String inputString = reader.readLine();

        int depth = Integer.parseInt(inputString);

        if (depth < 1) {
            System.out.println("The triangle is empty");
        } else {
            List<Row> rows = new ArrayList<>();
            rows.add(new Row(1)); // add first row

            for (int i = 1; i < depth; i++) {
                rows.add(new Row(rows.get(i - 1))); //add new row based on previous row
            }

            for (int i = 0; i < depth; i++) {
                System.out.print(getIndentation(rows.get(i), rows.get(depth - 1))); //print spaces to maintain triangle's shape
                System.out.println(rows.get(i)); //print row
            }

        }
    }

    private static String getIndentation(Row currentRow, Row lastRow) {
        return StringUtils.repeat(" ", (lastRow.toString().length() / 2 - currentRow.toString().length() / 2));
    }

}
