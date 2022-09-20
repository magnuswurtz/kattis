from sys import stdin
var_to_val = dict()
val_to_var = dict()


for line in stdin:
    line_list = line.strip().split()
    finit = False
    if line_list[0] == "def":
        if line_list[1] in var_to_val:
            del val_to_var[var_to_val[line_list[1]]]
        var_to_val[line_list[1]] = line_list[2]
        val_to_var[line_list[2]] = line_list[1]
    elif line_list[0] == "calc":
        final_exp = []
        for elem in line_list[1:]:
            if elem == "=":
                break
            if elem == '+' or elem == '-':
                final_exp.append(elem)
            else:
                value = var_to_val.get(elem)
                if value is None:
                    print(" ".join(line_list[1:]) + " unknown")
                    finit = True
                    break
                else:
                    final_exp.append(value)
        if not finit:
            result = str(eval("".join(final_exp)))
            if val_to_var.get(result) is None:
                print(" ".join(line_list[1:]) + " unknown")
            else: print(" ".join(line_list[1:]) + " " + val_to_var.get(result))
    elif line_list[0] == "clear":
        var_to_val = dict()
        val_to_var = dict()

