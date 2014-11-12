package javtopack;

import java.util.ArrayList;
import java.util.List;

import javtopack.Parser;
import javtopack.Output;

/**
 * This is a java console application to take several parameter inputs. Then perform change
 * operations and print the results to stdout (console)
 * 
 * @author Sergej Wasitsch
 * @version 1.0
 * @since 2014-11-11
 */
public class Javto {
   /**
    * Declaration of private member to store arguments of the -a parameter
    */
   private static List<Integer> aParList;
   /**
    * Declaration of private member to store arguments of the -b parameter
    */
   private static List<String> bParList;
   /**
    * Declaration of private member to store arguments of the -c parameter
    */
   private static List<Integer> cParList;
   /**
    * Declaration of private member to store not defined (invalid) parameters
    */
   private static List<String> anyParList;
   
   /**
    * Getter for member aParList
    * @return Returns copy and not reference of member aParList
    */
   public List<Integer> getAParList( ) {
      List<Integer> copyList = new ArrayList<Integer>( );
      for( Integer num : aParList ) {
         copyList.add( num );
      }
      return copyList;
   }
   
   /**
    * Getter for member bParList
    * @return Returns copy and not reference of member bParList
    */
   public List<String> getBParList( ) {
      List<String> copyList = new ArrayList<String>( );
      for( String str : bParList ) {
         copyList.add( str );
      }
      return copyList;
   }
   
   /**
    * Getter for member cParList
    * @return Returns copy and not reference of member cParList
    */
   public List<Integer> getCParList( ) {
      List<Integer> copyList = new ArrayList<Integer>( );
      for( Integer num : cParList ) {
         copyList.add( num );
      }
      return copyList;
   }
   
   /**
    * Getter for member anyParList
    * @return Returns copy and not reference of member anyParList
    */
   public List<String> getAnyParList( ) {
      List<String> copyList = new ArrayList<String>( );
      for( String str : anyParList ) {
         copyList.add( str );
      }
      return copyList;
   }
   
   /**
    * Main method
    * 
    * @param args Contains input arguments:
    * -a double double -> to perform sum operation
    * -b string char -> to perform String manipulation
    * -c double int -> to exponentiate 
    * Any other invalid argument will be identified and not processed
    */
   public static void main( String[] args ) {
      // Initialization of ArrayList members
      aParList = new ArrayList<Integer>( );
      bParList = new ArrayList<String>( );
      cParList = new ArrayList<Integer>( );
      anyParList = new ArrayList<String>( );
      
      // Create objects from classes Parser and Output
      Parser objPar = new Parser( );
      Output objOut = new Output( );
      
      /**
       * Call method startParsing( ) of object objPar to identify transferred parameters and
       * place them into ArrayList members
       * 
       * @param args (Can) Contain Strings with several parameters
       * @param aParList Reference of member aParList
       * @param bParList Reference of member bParList
       * @param cParList Reference of member cParList
       * @param anyParList Reference of member anyParList
       */
      objPar.startParse( args, aParList, bParList, cParList, anyParList );
      
      // Check if size of member aParList is 2
      if( aParList.size( ) == 2 ) {
         // Call private method perfSum( )
         perfSum( );
      }
      // Check if size of member bParList is 2
      if( bParList.size( ) == 2 ) {
         // Call private method perfStrManinpulation( )
         perfStrManinpulation( );
      }
      // Check if size of member cParList is 2
      if( cParList.size( ) == 2 ) {
         // Call private method perfExponent( )
         perfExponent( );
      }
      
      /**
       * Call method startOutput( ) of object objOut to create output informations to processed
       * parameters and show them at stdout
       * 
       * @param aParList Reference of member aParList
       * @param bParList Reference of member bParList
       * @param cParList Reference of member cParList
       * @param anyParList Reference of member anyParList
       */
      objOut.startOutput( aParList, bParList, cParList, anyParList );
   }
   
   /**
    * Private method to perform sum operation of given number1 and number2
    */
   private static void perfSum( ) {
      // Perform sum operation of both values and add result to member aParList
      aParList.add( aParList.get( 0 ) + aParList.get( 1 ) );
   }
   
   /**
    * Private method to remove specified char from given string
    */
   private static void perfStrManinpulation( ) {
      // Check if values at index 0 and 1 of member bParList are not null and string at index 1
      // has size of one element (char)
      if( bParList.get( 0 ).isEmpty( ) == false && bParList.get( 1 ).isEmpty( ) == false && 
            bParList.get( 1 ).length( ) == 1 ) {
         // Remove char from string
         bParList.add( bParList.get( 0 ).replace( bParList.get( 1 ), "" ) );
      }
   }

   /**
    * Private method to raise number1 to higher power of number2
    */
   private static void perfExponent( ) {
      // Check if values at index 0 and 1 of member cParList are not null and number at index 1
      // is natural number
      if( cParList.get( 0 ) != null && cParList.get( 1 ) != null && cParList.get( 1 ) % 1 == 0 ) {
         // Perform number at index 0 in the power of number at index 1
         // TODO Option of risk when performing conversion from double to int -> try catch maybe
         cParList.add( ( int )Math.round( Math.pow( cParList.get( 0 ), cParList.get( 1 ) ) ) );
      }
   }
}
