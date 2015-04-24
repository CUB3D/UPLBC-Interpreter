package call.upl.node;

import call.upl.core.UPLParser;
import call.upl.core.UPLUtils;
import call.upl.core.Value;

public class ParseNodePsh extends ParseNode
{
	public ParseNodePsh()
	{
		super("psh");
	}
	
	@Override
	public int execute(UPLParser parser, String[] args, int curLine)
	{
		String name = args[1];

		Value value = UPLUtils.getValue(name, parser);


		parser.getStack().push(value);
		
		return curLine;
	}
}