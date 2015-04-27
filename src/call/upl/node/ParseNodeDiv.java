package call.upl.node;

import java.math.BigDecimal;

import call.upl.core.UPLParser;
import call.upl.core.UPLUtils;
import call.upl.core.Value;

public class ParseNodeDiv extends ParseNode
{
	public ParseNodeDiv()
	{
		super("div");
	}

	@Override
	public int execute(UPLParser parser, String[] args, int curLine, String line)
	{
		String namea = args[1];
		String nameb = args[2];

		BigDecimal valuea = UPLUtils.getValue(namea, parser).getNumber();
		BigDecimal valueb = UPLUtils.getValue(nameb, parser).getNumber();

		BigDecimal result = valuea.divide(valueb);

		parser.getStack().push(new Value(result));
		
		return curLine;
	}

}
