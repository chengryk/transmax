As assigned on 26 April 2017

UI: console

Language: JAVA

Input: name of text file containing list of names and scores

Output:

    file named [name_of_input_file]-graded.txt containing list of names and scores sorted by score in descending order
    console printout of the above sorted list
    "Finished: created [output_file_name].txt

Assumptions:

    Format of a line in the input file = [surname,[name]], [score]
    If the line contains less than 2 commas, ignore line
    If the line contains more than 2 comma, the line is assumed to include [surname], [name]+, [score]
    If the score is not numeric, ignore line as score cannot be compared
    Print out of ignored line is required
