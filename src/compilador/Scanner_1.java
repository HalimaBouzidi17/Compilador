/* Generated By:JavaCC: Do not edit this line. Scanner_1.java */
package compilador;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class Scanner_1 implements Scanner_1Constants {

boolean Menosshort = false;
public void processa() throws Exception{
Token t = new Token ();

do {

t = getNextToken();
String nomeToken = tokenImage[t.kind];

} while(t.kind!=0); // 0 c'est le end of file EOF
}

public static void main(String args[], String x) throws ParseException, FileNotFoundException {

try {


}catch (Error e){
System.out.println(e.getMessage());
}

}

//*****************************************/
/*****         La grammaire          *****/
/*****************************************/
  final public interafc Prog() throws ParseException {
                   interafc ini;
    ini = S();
    jj_consume_token(0);
                   {if (true) return ini;}
    throw new Error("Missing return statement in function");
  }

  final public interafc S() throws ParseException {
                ArrayList<Composant> list = new ArrayList<Composant>();Automate aut ; interafc ini = new interafc();
    jj_consume_token(DEBUT);
    list = Interface();
    Init();
    aut = Actions();
    jj_consume_token(FIN);
                                                             ini.setAut(aut); ini.setCompos(list); {if (true) return ini;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Composant> Interface() throws ParseException {
                                    ArrayList<Composant> list = new ArrayList<Composant>();
    jj_consume_token(INTERFACE);
    list = ListComposant();
                                         {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<Composant> ListComposant() throws ParseException {
                                        ArrayList<Composant> list = new ArrayList<Composant>(); Composant c;
    c = Composant();
                    list.add(c);

    jj_consume_token(SEMIC);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMPOSANT:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      c = Composant();
                                                           list.add(c);
      jj_consume_token(SEMIC);
    }
 {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  final public Composant Composant() throws ParseException {
Token a,b;
String cont;
ArrayList<String> invs = null;
ArrayList<String> events = null;
ArrayList<propiete> props = null;
    jj_consume_token(COMPOSANT);
    a = jj_consume_token(IDLIB);
              Composant c = new Composant(); intermediar i = null ;c.setNom(a.image);/*System.out.println(c.getNom());*/
    jj_consume_token(POINTS);
    b = jj_consume_token(TypeCompo);
                  c.setType(b.image);/*System.out.println(c.getType());*/
    cont = choice1();
                    c.setContainer(cont);
    props = Propi();
 c.setprops(props);System.out.println((props.get(0)).getType());
    i = choice();
 c.setinvs(i.getInvs());c.setevents(i.getEvents());System.out.println(c.getEvents());
 {if (true) return c;}
    throw new Error("Missing return statement in function");
  }

  final public String choice1() throws ParseException {
                    Token cont;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBR:
      jj_consume_token(LBR);
      cont = jj_consume_token(IDLIB);
      jj_consume_token(RBR);
      jj_consume_token(SEMIC);
                                {if (true) return cont.image;}
      break;
    case SEMIC:
      jj_consume_token(SEMIC);
                                                               {if (true) return "";}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public intermediar choice() throws ParseException {
                        intermediar i = new intermediar() ; ArrayList<String> invs = null; ArrayList<String> events = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INV:
      invs = Invs();
      events = Events();
                                    i.setinvs(invs);i.setevents(events);{if (true) return i;}
      break;
    case EVT:
      events = Events();
                                                                                                         i.setevents(events);{if (true) return i;}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> Invs() throws ParseException {
                            ArrayList<String> invs;
    jj_consume_token(INV);
    invs = ListInv();
                         {if (true) return invs;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> ListInv() throws ParseException {
                               String inv; ArrayList<String> invs = new ArrayList<String>() ;
    inv = Inv();
              invs.add(inv);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMIC:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
      jj_consume_token(SEMIC);
      inv = Inv();
                      invs.add(inv);
    }
 {if (true) return invs;}
    throw new Error("Missing return statement in function");
  }

  final public String Inv() throws ParseException {
                Token inv;
    inv = jj_consume_token(IDLIB);
    jj_consume_token(ASSIGN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDLIB:
      jj_consume_token(IDLIB);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case LOGIC_CONSTANT:
      jj_consume_token(LOGIC_CONSTANT);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
                                                                 {if (true) return inv.image;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<propiete> Propi() throws ParseException {
                               ArrayList<propiete> list = new ArrayList<propiete>();
    jj_consume_token(PROP);
    list = ListProp();
                           {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<propiete> ListProp() throws ParseException {
                                  propiete p; ArrayList<propiete> list = new ArrayList<propiete>();
    p = Prop();
                 list.add(p);
    jj_consume_token(SEMIC);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDLIB:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_3;
      }
      p = Prop();
                                                   list.add(p);
      jj_consume_token(SEMIC);
    }
                                                                          {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  final public propiete Prop() throws ParseException {
                    propiete p = new  propiete(); String type; ArrayList<String> props = new ArrayList<String>();
    props = ListIDLIB();
    jj_consume_token(POINTS);
    type = IDLIBs();
                                                  p.setNom(props); p.setType(type); {if (true) return p;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> ListIDLIB() throws ParseException {
                                 Token t; ArrayList<String> props = new ArrayList<String>() ;
    t = jj_consume_token(IDLIB);
                props.add(t.image);
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_4;
      }
      jj_consume_token(COMMA);
      t = jj_consume_token(IDLIB);
                                                            props.add(t.image);
    }
                                                                                   {if (true) return props;}
    throw new Error("Missing return statement in function");
  }

  final public String IDLIBs() throws ParseException {
                  String type;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPENACCOLADE:
      jj_consume_token(OPENACCOLADE);
      ListeIDLIB();
      jj_consume_token(CLOSEDACCOLADE);
                                               type = "Enum"; {if (true) return type;}
      break;
    case Bool:
      jj_consume_token(Bool);
          type = "Booleen"; {if (true) return type;}
      break;
    case Int:
      jj_consume_token(Int);
         type = "Entier"; {if (true) return type;}
      break;
    case String:
      jj_consume_token(String);
            type = "String"; {if (true) return type;}
      break;
    case Char:
      jj_consume_token(Char);
          type = "Char"; {if (true) return type;}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void ListeIDLIB() throws ParseException {
    jj_consume_token(IDLIB);
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case COMMA:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_5;
      }
      jj_consume_token(COMMA);
      jj_consume_token(IDLIB);
    }
  }

  final public ArrayList<String> Events() throws ParseException {
                              ArrayList<String> types = new ArrayList<String>() ;
    jj_consume_token(EVT);
    types = ListEvent();
                           {if (true) return types;}
    throw new Error("Missing return statement in function");
  }

  final public ArrayList<String> ListEvent() throws ParseException {
                                 String type; ArrayList<String> types = new ArrayList<String>() ;
    type = Event();
                   types.add(type);
    jj_consume_token(SEMIC);
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Type1:
      case Type2Fen:
        ;
        break;
      default:
        jj_la1[9] = jj_gen;
        break label_6;
      }
      type = Event();
                                                             types.add(type);
      jj_consume_token(SEMIC);
    }
                                                                                         {if (true) return types;}
    throw new Error("Missing return statement in function");
  }

  final public String Event() throws ParseException {
                  String type;
    type = TypeEvent();
    choice3();
    ListTypeEvent();
    jj_consume_token(CLOSEDACCOLADE);
                                                                    {if (true) return type;}
    throw new Error("Missing return statement in function");
  }

  final public void choice3() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBR:
      jj_consume_token(LBR);
      jj_consume_token(IDLIB);
      jj_consume_token(RBR);
      jj_consume_token(OPENACCOLADE);
      break;
    case OPENACCOLADE:
      jj_consume_token(OPENACCOLADE);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public String TypeEvent() throws ParseException {
                      Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Type1:
      t = jj_consume_token(Type1);
              {if (true) return t.image;}
      break;
    case Type2Fen:
      t = jj_consume_token(Type2Fen);
                                                {if (true) return t.image;}
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void ListTypeEvent() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IF:
      IFCond();
      break;
    case LBR:
    case APOSTROPHE:
    case LOGIC_CONSTANT:
    case NUMBER:
    case IDLIB:
      Aff();
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SEMIC:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_7;
      }
      jj_consume_token(SEMIC);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
        IFCond();
        break;
      case LBR:
      case APOSTROPHE:
      case LOGIC_CONSTANT:
      case NUMBER:
      case IDLIB:
        Aff();
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public void IFCond() throws ParseException {
    jj_consume_token(IF);
    Condition();
    jj_consume_token(THEN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBR:
    case APOSTROPHE:
    case LOGIC_CONSTANT:
    case NUMBER:
    case IDLIB:
      Affectation();
      break;
    case IF:
      IFCond();
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Condition() throws ParseException {
    jj_consume_token(IDLIB);
    SensCond();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDLIB:
      jj_consume_token(IDLIB);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case LOGIC_CONSTANT:
      jj_consume_token(LOGIC_CONSTANT);
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void SensCond() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Equal:
      jj_consume_token(Equal);
      break;
    case Diffrent:
      jj_consume_token(Diffrent);
      break;
    case Comp:
      jj_consume_token(Comp);
      break;
    default:
      jj_la1[17] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Affectation() throws ParseException {
    Aff();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case AND:
        ;
        break;
      default:
        jj_la1[18] = jj_gen;
        break label_8;
      }
      jj_consume_token(AND);
      Aff();
    }
  }

  final public void Aff() throws ParseException {
    E();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      jj_consume_token(ASSIGN);
      E();
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
  }

  final public void E() throws ParseException {
    T();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS_SIGN:
      case MINUS_SIGN:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_9;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS_SIGN:
        jj_consume_token(PLUS_SIGN);
        break;
      case MINUS_SIGN:
        jj_consume_token(MINUS_SIGN);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      T();
    }
  }

  final public void T() throws ParseException {
    F();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULT_SIGN:
      case DIV_SIGN:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULT_SIGN:
        jj_consume_token(MULT_SIGN);
        break;
      case DIV_SIGN:
        jj_consume_token(DIV_SIGN);
        break;
      default:
        jj_la1[23] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      F();
    }
  }

  final public void F() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBR:
      jj_consume_token(LBR);
      E();
      jj_consume_token(RBR);
      break;
    case IDLIB:
      jj_consume_token(IDLIB);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case LOGIC_CONSTANT:
      jj_consume_token(LOGIC_CONSTANT);
      break;
    case APOSTROPHE:
      jj_consume_token(APOSTROPHE);
      jj_consume_token(IDLIB);
      jj_consume_token(APOSTROPHE);
      break;
    default:
      jj_la1[24] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Init() throws ParseException {
    jj_consume_token(INIT);
    ListInit();
  }

  final public void ListInit() throws ParseException {
    InitObj();
    jj_consume_token(SEMIC);
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IDLIB:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_11;
      }
      InitObj();
      jj_consume_token(SEMIC);
    }
  }

  final public void InitObj() throws ParseException {
    jj_consume_token(IDLIB);
    jj_consume_token(Relation);
    jj_consume_token(IDLIB);
    jj_consume_token(ASSIGN);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDLIB:
      jj_consume_token(IDLIB);
      break;
    case NUMBER:
      jj_consume_token(NUMBER);
      break;
    case LOGIC_CONSTANT:
      jj_consume_token(LOGIC_CONSTANT);
      break;
    default:
      jj_la1[26] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public Automate Actions() throws ParseException {
                      Automate aut ;
    jj_consume_token(ACTIONS);
    aut = ListActions();
                              {if (true) return aut;}
    throw new Error("Missing return statement in function");
  }

  final public Automate ListActions() throws ParseException {
 int n=0;
 int j=0;
 int i=0;
 int k=0;
 Automate aut = new Automate();
 Liste[][] trans = new Liste[128][128];
 aut.setQ0(n);
 String tran;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPENACCOLADE:
      jj_consume_token(OPENACCOLADE);
      ListActions();
      tran = transit();
 if(tran == ";")
{
trans[n++][j++] = new Liste(n, null);
}
else if(tran == "+")
    {
     trans[n++][j++] = new Liste(n++, new Liste(n++, null));
    }
    else if (tran == "~")
    {
     i = n;
     k = n + 1;
     trans[n++][j++] = new Liste(k, null);
     trans[k][j++] = new Liste(j, null);
    }
      ListActions();
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEMIC:
        case PLUS_SIGN:
        case CHOIX:
          ;
          break;
        default:
          jj_la1[27] = jj_gen;
          break label_12;
        }
        tran = transit();
 if(tran == ";")
{
trans[n++][j++] = new Liste(n, null);
}
else if(tran == "+")
    {
     trans[n++][j++] = new Liste(n++, new Liste(n++, null));
    }
    else if (tran == "~")
    {
     i = n;
     k = n + 1;
     trans[n++][j++] = new Liste(k, null);
     trans[k][j++] = new Liste(j, null);
    }
        ListActions();
      }
      jj_consume_token(CLOSEDACCOLADE);
      label_13:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEMIC:
        case PLUS_SIGN:
        case CHOIX:
          ;
          break;
        default:
          jj_la1[28] = jj_gen;
          break label_13;
        }
        tran = transit();
 if(tran == ";")
{
trans[n++][j++] = new Liste(n, null);
}
else if(tran == "+")
    {
     trans[n++][j++] = new Liste(n++, new Liste(n++, null));
    }
    else if (tran == "~")
    {
     i = n;
     k = n + 1;
     trans[n++][j++] = new Liste(k, null);
     trans[k][j++] = new Liste(j, null);
    }
        ListActions();
      }
                  aut.setTransit(trans); {if (true) return aut;}
      break;
    case Type1:
      singleAction();
                   aut.setTransit(trans); {if (true) return aut;}
      break;
    default:
      jj_la1[29] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public String transit() throws ParseException {
                    Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SEMIC:
      t = jj_consume_token(SEMIC);
            {if (true) return t.image;}
      break;
    case PLUS_SIGN:
      t = jj_consume_token(PLUS_SIGN);
                                             {if (true) return t.image;}
      break;
    case CHOIX:
      t = jj_consume_token(CHOIX);
                                                                          {if (true) return t.image;}
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public void singleAction() throws ParseException {
    jj_consume_token(Type1);
    jj_consume_token(LBR);
    jj_consume_token(IDLIB);
    jj_consume_token(RBR);
  }

  /** Generated Token Manager. */
  public Scanner_1TokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[31];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x1400,0x0,0x1000,0x0,0x0,0x200,0x8000,0x200,0x0,0x8400,0x0,0x20100400,0x1000,0x20100400,0x20100400,0x0,0xe0000,0x4000000,0x2000,0x600000,0x600000,0x1800000,0x1800000,0x100400,0x0,0x0,0x2201000,0x2201000,0x8000,0x2201000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x2,0x0,0x18,0x0,0xe000,0x8000,0x0,0x3c0,0x0,0x1800,0x0,0x1800,0xe000,0x0,0xe000,0xe000,0xe000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xe000,0x8000,0xe000,0x0,0x0,0x800,0x0,};
   }

  /** Constructor with InputStream. */
  public Scanner_1(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Scanner_1(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new Scanner_1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Scanner_1(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new Scanner_1TokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Scanner_1(Scanner_1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(Scanner_1TokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 31; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[50];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 31; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 50; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}