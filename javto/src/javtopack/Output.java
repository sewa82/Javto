package javtopack;

import java.util.List;

/**
 * This class will generate output depending on parsed data from Parser class object
 * 
 * @author Sergej Wasitsch
 * @version 1.0
 * @since 2014-11-11
 */
public class Output {
   /**
    * Public constructor of class Output
    */
   public Output( ) {
   }
   
   /**
    * Public method to call private function process( )
    * 
    * @param aParList Contains reference of member aParList
    * @param bParList Contains reference of member bParList
    * @param cParList Contains reference of member cParList
    * @param anyParList Contains reference of member anyParList
    */
   public void startOutput( List<Integer> aParList, List<String> bParList,
         List<Integer> cParList, List<String> anyParList ) {
      process( aParList, bParList, cParList, anyParList );
   }
   
   /**
    * Private method to process data from transferred references of ArrayList members and
    * generate informational strings which will be send to stdout
    * 
    * @param aParList Contains reference of member aParList
    * @param bParList Contains reference of member bParList
    * @param cParList Contains reference of member cParList
    * @param anyParList Contains reference of member anyParList
    */
   private void process( List<Integer> aParList, List<String> bParList,
         List<Integer> cParList, List<String> anyParList ) {
      //Check if reference aParList is not null 
      if( aParList != null ) {
         // Check if aParList is not empty and contains three numbers (index: 0, 1, 2)
         if( aParList.isEmpty( ) == false && aParList.size( ) == 3 ) {
            // Generate output string and send it to stdout
            System.out.println( String.format( "Die Summe von %d und %d ist %d.",
               aParList.get( 0 ), aParList.get( 1 ), aParList.get( 2 ) ) );
         }
      }
      
      //Check if reference bParList is not null 
      if( bParList != null ) {
         // Check if bParList is not empty and contains three strings (index: 0, 1, 2)
         if( bParList.isEmpty( ) == false && bParList.size( ) == 3 ) {
            // Generate output string and send it to stdout
            System.out.println( String.format( "Das Wort \"%s\" ohne \"%s\" lautet \"%s\".",
               bParList.get( 0 ), bParList.get( 1 ), bParList.get( 2 ) ) );
         }
      }
      
      //Check if reference cParList is not null 
      if( cParList != null ) {
         // Check if cParList is not empty and contains three numbers (index: 0, 1, 2)
         if( cParList.isEmpty( ) == false && cParList.size( ) == 3 ) {
            // Generate output string and send it to stdout
            System.out.println( String.format( "%d potenziert mit %d ergibt %d.",
               cParList.get( 0 ), cParList.get( 1 ), cParList.get( 2 ) ) );
         }
      }
      
      //Check if reference anyParList is not null 
      if( anyParList != null ) {
         // Check if anyParList is not empty
         if( anyParList.isEmpty( ) == false ) {
            // Generate for each invalid parameter an output string and send it to stdout
            for( String param : anyParList ) {
               System.out.println( String.format( "Der Parameter \"%s\" ist nicht bekannt.",
                  param ) );
            }
         }
      }
   }
}
