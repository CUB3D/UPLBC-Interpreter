package call.upl.node;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import call.upl.core.UPLParser;


public abstract class ParseNode
{
	private static Set<ParseNode> nodes = new HashSet<ParseNode>();

	public static final ParseNode mov = new ParseNodeMov();
	
	public static final ParseNode add = new ParseNodeAdd();
	public static final ParseNode sub = new ParseNodeSub();
	public static final ParseNode mul = new ParseNodeMul();
	public static final ParseNode div = new ParseNodeDiv();
	
	public static final ParseNode pop = new ParseNodePop();
	public static final ParseNode psh = new ParseNodePsh();
	public static final ParseNode imt = new ParseNodeInt();
	public static final ParseNode jmp = new ParseNodeJmp();
	public static final ParseNode if_ = new ParseNodeIf_();
	public static final ParseNode dwd = new ParseNodeDwd();
	public static final ParseNode wil = new ParseNodeWhl_();
	public static final ParseNodeArray PARSE_NODE_ARRAY = new ParseNodeArray();
	public static final ParseNodeModulus PARSE_NODE_MODULUS = new ParseNodeModulus();
	public static final ParseNodeNsp PARSE_NODE_NSP = new ParseNodeNsp();
    public static final ParseNodeEndNsp PARSE_NODE_END_NSP = new ParseNodeEndNsp();
	public static final ParseNodeCreateNativeClass PARSE_NODE_CREATE_NATIVE_CLASS = new ParseNodeCreateNativeClass();
    public static final ParseNodeCallNativeMethod PARSE_NODE_CALL_NATIVE_METHOD = new ParseNodeCallNativeMethod();

	
	private String opCode;
	
	public ParseNode(String opcode)
	{
		this.opCode = opcode;
		
		nodes.add(this);
	}
	
	public abstract int execute(UPLParser parser, String[] args, int curLine, String line, List<String> code);
	
	public String getOpcode()
	{
		return this.opCode;
	}
	
	
	public static ParseNode getNode(String opCode)
	{
		for(ParseNode pn : nodes)
			if(pn.getOpcode().equals(opCode))
				return pn;
		
		return null;
	}
}
