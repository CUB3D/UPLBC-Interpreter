package call.upl.node;

import call.upl.core.UPL;
import call.upl.core.UPLParser;
import call.upl.core.UPLUtils;
import call.upl.core.value.StringValue;
import call.upl.core.value.Value;

import java.util.List;

public class ParseNodeDwd extends ParseNode
{
	public ParseNodeDwd()
	{
		super("dwd");
	}

	@Override
	public int execute(UPLParser parser, String[] args, int curLine, String line, List<String> code)
	{
		String var = args[1];

        // dwd Answer: .

        line = line.replaceFirst(getOpcode() + " " + var + " ", "");

        // Answer: .

		UPLUtils.putValue(var, new StringValue(line), parser);

        if(UPL.DEBUG)
        {
            System.out.println("DWD, S: " + line + ", Var: " + var);
        }

		return curLine;
	}
}
