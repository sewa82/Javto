package javtopack;

import java.util.List;


/**
 * Class which will take care of arguments -> take input (args) and parse its contents.
 * It's also possible (and time saving) to use the Apache "Commons CLI library instead" of
 * create own parser.
 * 
 * @author Sergej Wasitsch
 * @version 1.0
 * @since 2014-11-11
 */
public class Parser {
   /**
    * Private member stores parameter flag -a
    */
   private final String aPar = "-a";
   /**
    * Private member stores parameter flag -b
    */
   private final String bPar = "-b";
   /**
    * Private member stores parameter flag -c
    */
   private final String cPar = "-c";
   /**
    * Private member stores pattern to use as regex for (invalid) parameter
    */
   private final String pattern = "(-[d-zD-Z]){1,1}";
   
   /**
    * Public constructor
    */
   public Parser( ) {
   }
   
   /**
    * Public method to call private function process( )
    * 
    * @param args (Can) Contain Strings with several parameters
    * @param aParList Contains reference of member aParList
    * @param bParList Contains reference of member bParList
    * @param cParList Contains reference of member cParList
    * @param anyParList Contains reference of member anyParList
    */
   public void startParse( String[] args, List<Integer> aParList, List<String> bParList,
         List<Integer> cParList, List<String> anyParList ) {
      process( args, aParList, bParList, cParList, anyParList );
   }
   
   /**
    * Private method to parse the args StringArray and set the ArrayList members with found
    * parameters (-a, -b, -c,). All found invalid parameters will be stored in member anyParList
    * 
    * @param args (Can) Contain Strings with several parameters
    * @param aParList Contains reference of member aParList
    * @param bParList Contains reference of member bParList
    * @param cParList Contains reference of member cParList
    * @param anyParList Contains reference of member anyParList
    */
   private void process( String[] args, List<Integer> aParList, List<String> bParList,
         List<Integer> cParList, List<String> anyParList ) {
      // Check if args is not null and not empty
      if( args != null && args.length > 0 ) {
         // At first place it is essential to determine a 'valid' parameter, thus it has to be of
         // one of the following character string -a, -b, -c, each followed by two values. All
         // other parameters are invalid, thus only the parameter char will be stored.
         // The valid parameters will be processed unique, thus at first occurrence of each. All
         // following valid parameters of the same name will be ignored!
         // Process StringArray args in an for loop until the end of the Array
         for( int idx = 0, intIdx = 0 ; idx < args.length ; idx++ ) {
            // Check -a parameter
            if( args[idx].contains( aPar ) == true && aParList.size( ) < 2 ) {
               // Try to extract first value
               intIdx = idx + 1;
               if( intIdx < args.length ) {
                  try {
                     aParList.add( Integer.parseInt( args[intIdx].replaceAll( "\\s+","" ) ) );
                  } catch ( NumberFormatException e ) {
                     // Optional handle NumberFormatException
                  }
               }
               // Try to extract second value
               intIdx = intIdx + 1;
               if( intIdx < args.length ) {
                  try {
                     aParList.add( Integer.parseInt( args[intIdx].replaceAll( "\\s+","" ) ) );
                  } catch ( NumberFormatException e ) {
                     // Optional handle NumberFormatException
                  }
               }
               // Set idx member
               switch( aParList.size( ) ) {
                  case 1 : idx += 1;
                  case 2 : idx += 2;
               }
            }
            // Check -b parameter
            else if( args[idx].contains( bPar ) == true && bParList.size( ) < 2 ) {
               // Try to extract first string value
               intIdx = idx + 1;
               if( intIdx < args.length ) {
                  bParList.add( args[intIdx].replaceAll( "\\s+","" ) );
               }
               // Try to extract second string value
               intIdx = intIdx + 1;
               if( intIdx < args.length ) {
                  bParList.add( args[intIdx].replaceAll( "\\s+","" ) );
               }
               // Set idx member
               switch( bParList.size( ) ) {
                  case 1 : idx += 1;
                  case 2 : idx += 2;
               }
            }
            // Check -c parameter
            else if( args[idx].contains( cPar ) == true && cParList.size( ) < 2 ) {
               // Try to extract first value
               intIdx = idx + 1;
               if( intIdx < args.length ) {
                  try {
                     cParList.add( Integer.parseInt( args[intIdx].replaceAll( "\\s+","" ) ) );
                  } catch ( NumberFormatException e ) {
                     // Optional handle NumberFormatException
                  }
               }
               // Try to extract second value
               intIdx = intIdx + 1;
               if( intIdx < args.length ) {
                  try {
                     cParList.add( Integer.parseInt( args[intIdx].replaceAll( "\\s+","" ) ) );
                  } catch ( NumberFormatException e ) {
                     // Optional handle NumberFormatException
                  }
               }
               // Set idx member
               switch( cParList.size( ) ) {
                  case 1 : idx += 1;
                  case 2 : idx += 2;
               }
            }
            // Check any invalid parameter of pattern "-char"
            else if( args[idx].matches( pattern ) == true ) {
               // If value match the pattern of an argument, it will be stored into ArrayList
               // member anyParList without the char '-'
               anyParList.add( args[idx].replaceAll( "\\s+","" ).substring( 1 ) );
            }
         }
      }
   }
}
