import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.lang.Object;
import java.lang.System;
import java.util.Arrays;
import java.lang.InterruptedException;


public class FinnAntall //implements Runnable
{
	
	
			/*
		    
				    //{ code goes here }catch (IOException ex){Thread.currentThread().interrupt();}}}
					
	                    int k = 8; 
		                double antallOrdTotalt = words.size();
		                int antallOrdTotaltInt = (int) antallOrdTotalt;
		                double antallOrdPerK = (antallOrdTotalt/k);
		                //System.out.println(antallOrdPerK);
		                long antallOrdPerKL =(long)antallOrdPerK;
		                int antallOrdPerKInt = (int) antallOrdPerKL;
		                //ArrayList<ArrayList<String>> wordsSubLists = new ArrayList<ArrayList<String>>();
			            int task = antallOrdPerKInt+1;
			            String[][] wordsSublists = new String[k][task];
			            //ArrayList<String>[][] part = new ArrayList<String>[2][5];
                        //runde ned;
			            //int q = divide*k; // runde ned
			            //if q != words.length
			            if (k!=1 && antallOrdPerK != (int) antallOrdPerK)
			            {
			                int maxI = k-1;
			                int maxJ = k;
                            //System.out.println(wordsSublists);
                            //System.out.print(wordsSublists.length());
                            for (int i = 0; i <= maxI; i++) 
                            {
			                    ArrayList<String> time = new ArrayList<String>(words.subList(i*antallOrdPerKInt,((i+1)*(antallOrdPerKInt))));
				                int v = i*antallOrdPerKInt;
				                int a = (i+1)*(antallOrdPerKInt);
				                //System.out.println(v + " v");
				                //System.out.println(a  + " a");
				                //System.out.println(time);
					            //wordsSubLists.add(new ArrayList<String>());
					            Object[] times2 = time.toArray();
					            //String[] times3 = (String[]) times2;
					            //wordsSubLists.add(i,time);
					            String[] times3 = Arrays.copyOf(times2, times2.length, String[].class);
					            int c = times3.length;
					            //System.out.println(c+ " times3 length");
					            for (int m = 0; m < times3.length; m++)
					            {
					                wordsSublists[i][m] = times3[m];
					            }
			                    //wordsSublists[i][antallOrdPerKInt] = "";
                            }
				            ArrayList<String> rest = new ArrayList<String>(words.subList(k*antallOrdPerKInt,(antallOrdTotaltInt )));
			                //int x = k*antallOrdPerKInt;
			                //int y =(antallOrdTotaltInt - 1);
			                //System.out.println(x+ " x");
			                //System.out.println(y+ " y");
			                Object[] rest2 = rest.toArray();
			                //String[] rest3 = (String[]) rest2;
			                String[] rest3 = Arrays.copyOf(rest2, rest2.length, String[].class);
			                int rest3Lengde = rest3.length;
			                //System.out.println(rest3Lengde+ " rest3Lengde");
			                //System.out.println(antallOrdPerKInt+ " antallOrdPerK");
				            for (int i = 0; i< rest3Lengde; i++)
			                {
				                wordsSublists[i][antallOrdPerKInt] = rest3[i];
				                //String event = rest.get(i);
					            //wordsSubLists.set(i,antallOrdPerKInt, event);
				            }
					}
                    catch (IOException ex)
					{
						Thread.currentThread().interrupt();
					}
					
			}}					
				          
						String givenWord = "scolecid";
				        int counterWord;
				//lage k-1 andre trader		
			           for (int z = 0; z < k; z++)
				       {
					//create new thread
					        Runnable n = new MyRunnable();
		                    Thread t = new Thread(n);
		                    t.start();
							
							
					        for (int y = 0; y <= antallOrdPerKInt; y++;)
					        {
					        String wordIt = wordsSublists[z][y];
					        if (wordIt.equals(givenWord))
						{
						    counterWord ++;	
						}	
				}	
			}	
			System.out.println(counter);
				            //int work = k-rest3Lengde;
				            //for (int j = 1; j <= work; j++ )
		}		            //{
					          //  wordsSublists[k-j][antallOrdPerKInt]
				            //}	
				            //int lo = wordsSublists[4].length;
				            //System.out.println(lo + " lengde 0 nye liste");
				            //for(int i = 0; i< wordsSublists[7].length; i++)
				            //{
					            //String wordy = wordsSublists[7][i];
	}        //System.out.println(wordy);
					//}
                    //catch (InterruptedException exception)
					
					//}
			//catch(InterruptedException)
			//{
			    //System.out.prinln("Error");	
			//}
                    //{
							
					//}						
				//}
				
				*/
	
    public static void main (String[] args) throws FileNotFoundException
    {
		try
		{
			//private int k;
            File inputFile = new File("minfil.txt");
		    Scanner in = new Scanner(inputFile);
			String line = in.nextLine();
			//System.out.println(line);
			
            String cS = Character.toString(line.charAt(0));
            int number = Integer.parseInt(cS);
            ArrayList<String> words = new ArrayList<String>(number);
			while (in.hasNextLine())
			{
			    //while (line.length() != 0)
			   // {
				   line = in.nextLine();
				   int lengde = line.length();
			       String w = line.substring(0,lengde);
                    words.add(w);
                				
			   // }	
			}	
		       
				int k = 8; 
				double antallOrdTotalt = words.size();
				int antallOrdTotaltInt = (int) antallOrdTotalt;
				
				
				double antallOrdPerK = (antallOrdTotalt/k);
				
				
				System.out.println(antallOrdPerK);
				long antallOrdPerKL =(long)antallOrdPerK;
				int antallOrdPerKInt = (int) antallOrdPerKL;
				//ArrayList<ArrayList<String>> wordsSubLists = new ArrayList<ArrayList<String>>();
				int task = antallOrdPerKInt+1;
				String[][] wordsSublists = new String[k][task];
				//ArrayList<String>[][] part = new ArrayList<String>[2][5];
                
				//runde ned;
				//int q = divide*k; // runde ned
				//if q != words.length
				if (k!=1 && antallOrdPerK != (int) antallOrdPerK)
				{
					
					int maxI = k-1;
					int maxJ = k;
                    //System.out.println(wordsSublists);
                   //System.out.print(wordsSublists.length());
                    for (int i = 0; i <= maxI; i++) 
                    {
						
						ArrayList<String> time = new ArrayList<String>(words.subList(i*antallOrdPerKInt,((i+1)*(antallOrdPerKInt))));
						int v = i*antallOrdPerKInt;
						int a = (i+1)*(antallOrdPerKInt);
						
						System.out.println(v + " v");
						System.out.println(a  + " a");
						
						//System.out.println(time);
						//wordsSubLists.add(new ArrayList<String>());
						Object[] times2 = time.toArray();
						//String[] times3 = (String[]) times2;
						//wordsSubLists.add(i,time);
					    String[] times3 = Arrays.copyOf(times2, times2.length, String[].class);
						int c = times3.length;
						System.out.println(c+ " times3 length");
						
						for (int m = 0; m < times3.length; m++)
						{
							 
							wordsSublists[i][m] = times3[m];
							
	
						}
						//wordsSublists[i][antallOrdPerKInt] = "";
                        						
						
					}
				}
			    
                  				
			   ArrayList<String> rest = new ArrayList<String>(words.subList(k*antallOrdPerKInt,(antallOrdTotaltInt )));
			   int x = k*antallOrdPerKInt;
			   int y =(antallOrdTotaltInt - 1);
			   System.out.println(x+ " x");
			   System.out.println(y+ " y");
			   Object[] rest2 = rest.toArray();
			   //String[] rest3 = (String[]) rest2;
			   String[] rest3 = Arrays.copyOf(rest2, rest2.length, String[].class);
			   
               int rest3Lengde = rest3.length;
			   System.out.println(rest3Lengde+ " rest3Lengde");
			   System.out.println(antallOrdPerKInt+ " antallOrdPerK");
			   
			  for (int i = 0; i< rest3Lengde; i++)
			   {
					wordsSublists[i][antallOrdPerKInt] = rest3[i];
				    //String event = rest.get(i);
					//wordsSubLists.set(i,antallOrdPerKInt, event);
					
				}
				
				
				int lo = wordsSublists[4].length;
				System.out.println(lo + " lengde 0 nye liste");
				
				for(int i = 0; i< wordsSublists[0].length; i++)
				{
					String wordy = wordsSublists[0][i];
					System.out.println(wordy);
				}	
				
				 
                   
				          
				String givenWord = "scolecid";
				int counterWord = 0;
				//lage k andre trader		
			    for (int z = 0; z < k; z++)
				{
					System.out.println(z + " z");
					//create new thread
					        //Runnable n = new MyRunnable();
		                    //Thread t = new Thread(n);
		                    //t.start();
				    for (y = 0; y <= antallOrdPerKInt; y++)
					{
						System.out.println(y+ " y");
					    String wordIt = wordsSublists[z][y];
						System.out.println(wordIt+ " wordIT");
						System.out.println(givenWord+ " givenWord");
					    if (wordIt != null && wordIt.equals(givenWord))
					    {
						    counterWord ++;	
						}
                        						
					}	
						

                        //public void run()   	
							
				}	
				Object[] words2 = words.toArray();
			    String[] words3 = Arrays.copyOf(words2, words2.length, String[].class);
		        int len = words3.length;
				antallOrdPerKInt = len-1;
				
				for (int z = 0; z < k; z++)
				{
					System.out.println(z + " z");
					//create new thread
					        //Runnable n = new MyRunnable();
		                    //Thread t = new Thread(n);
		                    //t.start();
				    for (y = 0; y <= antallOrdPerKInt; y++)
					{
						System.out.println(y+ " y");
					    for (y = 0; y <= antallOrdPerKInt; y++)
		                {
		                    String wordIt = words3[y];
			                    if (wordIt != null && wordIt.equals(givenWord))
			                    {
			                        counterWord ++;	
			                    }
                        }
					}	
						
		        }	
	
						
				
				//System.out.println(wordsSublists);	
				//ArrayList<String> check = new ArrayList<String> words.get(0);
				//int l = check.size;
				//System.out.println(l+ " lengde l");

                				
                //for (i = 0; i < antallOrdPerKInt; i++;)
				//{
					
				//	words.add(0,)
				//}

					// and j = 0, j < rest.size(), j++
                       //    wordsSublists[i][antallOrdPerK] = rest[j]					
					//Stringwords.subList((k-1)*AntallOrdPerK),(antallOrdTotalt-1));
					//int maxI2 = int(antallOrdTotalt-(k-1)*AntallOrdPerKRoundedUpInt);
					//for i = 0; i<= maxI2;i++; 
                     // wordsSublists[k--][i] = words.subList()					
					
				
				
            //for (String w: wordsSubLists)
		    //{	
	                
				//System.out.println(w + "\n");
			            
				   
			//}
						
		
		
		       // public void run()
		        //{
			        //try
			        //{
						/*
				        int k = 8; 
				        double antallOrdTotalt = words.size();
				        int antallOrdTotaltInt = (int) antallOrdTotalt;
				        double antallOrdPerK = (antallOrdTotalt/k);
				        //System.out.println(antallOrdPerK);
				        long antallOrdPerKL =(long)antallOrdPerK;
				        int antallOrdPerKInt = (int) antallOrdPerKL;
				        //ArrayList<ArrayList<String>> wordsSubLists = new ArrayList<ArrayList<String>>();
				        int task = antallOrdPerKInt+1;
				        String[][] wordsSublists = new String[k][task];
				        //ArrayList<String>[][] part = new ArrayList<String>[2][5];
                        //runde ned;
				        //int q = divide*k; // runde ned
				        //if q != words.length
				        if (k!=1 && antallOrdPerK != (int) antallOrdPerK)
				        {
					        int maxI = k-1;
					        int maxJ = k;
                            //System.out.println(wordsSublists);
                           //System.out.print(wordsSublists.length());
                            for (int i = 0; i <= maxI; i++) 
                            {
						        ArrayList<String> time = new ArrayList<String>(words.subList(i*antallOrdPerKInt,((i+1)*(antallOrdPerKInt))));
						        int v = i*antallOrdPerKInt;
						        int a = (i+1)*(antallOrdPerKInt);
						        //System.out.println(v + " v");
						        //System.out.println(a  + " a");
						        //System.out.println(time);
						        //wordsSubLists.add(new ArrayList<String>());
						        Object[] times2 = time.toArray();
						        //String[] times3 = (String[]) times2;
						        //wordsSubLists.add(i,time);
					            String[] times3 = Arrays.copyOf(times2, times2.length, String[].class);
						        int c = times3.length;
						        //System.out.println(c+ " times3 length");
						        for (int m = 0; m < times3.length; m++)
						        {
							        wordsSublists[i][m] = times3[m];
							    }
						        //wordsSublists[i][antallOrdPerKInt] = "";
                        	}
							ArrayList<String> rest = new ArrayList<String>(words.subList(k*antallOrdPerKInt,(antallOrdTotaltInt )));
			                //int x = k*antallOrdPerKInt;
			                //int y =(antallOrdTotaltInt - 1);
			                //System.out.println(x+ " x");
			                //System.out.println(y+ " y");
			                Object[] rest2 = rest.toArray();
			                //String[] rest3 = (String[]) rest2;
			                String[] rest3 = Arrays.copyOf(rest2, rest2.length, String[].class);
			                int rest3Lengde = rest3.length;
			                //System.out.println(rest3Lengde+ " rest3Lengde");
			                //System.out.println(antallOrdPerKInt+ " antallOrdPerK");
			                for (int i = 0; i< rest3Lengde; i++)
			                {
					            wordsSublists[i][antallOrdPerKInt] = rest3[i];
				                //String event = rest.get(i);
					            //wordsSubLists.set(i,antallOrdPerKInt, event);
					        }
							String givenWord = "scolecid";
							int counterWord;
							for (int z = 0; z < k; z++)
							{
								for (int y = 0; y <= antallOrdPerKInt; y++;)
								{
								    String wordIt = wordsSublists[z][y];
								    if (wordIt.equals(givenWord))
									{
									    counterWord ++;	
									}	
								      	
								}	
								   
							}	
				            //int work = k-rest3Lengde;
				            //for (int j = 1; j <= work; j++ )
				            //{
					          //  wordsSublists[k-j][antallOrdPerKInt]
				            //}	
				            //int lo = wordsSublists[4].length;
				            //System.out.println(lo + " lengde 0 nye liste");
				            //for(int i = 0; i< wordsSublists[7].length; i++)
				            //{
					            //String wordy = wordsSublists[7][i];
						}        //System.out.println(wordy);
						
					*/	
					//}
                    //catch (InterruptedException exception)
                    //{
							
					//}						
				//}
			    
                  				
			   
				//System.out.println(wordsSublists);	
				//ArrayList<String> check = new ArrayList<String> words.get(0);
				//int l = check.size;
				//System.out.println(l+ " lengde l");

                				
                //for (i = 0; i < antallOrdPerKInt; i++;)
				//{
					
				//	words.add(0,)
				//}

					// and j = 0, j < rest.size(), j++
                       //    wordsSublists[i][antallOrdPerK] = rest[j]					
					//Stringwords.subList((k-1)*AntallOrdPerK),(antallOrdTotalt-1));
					//int maxI2 = int(antallOrdTotalt-(k-1)*AntallOrdPerKRoundedUpInt);
					//for i = 0; i<= maxI2;i++; 
                     // wordsSublists[k--][i] = words.subList()					
					
				
				
            //for (String w: wordsSubLists)
		    //{	
           // Runnable r = new MyRunnable();
		    //))Thread t = new Thread(r);
		    //)t.start(); 	        
			
				//System.out.println(w + "\n");
			    //(new Thread(FinnAntall())).start();       
				//.interrupt();
				
				//for (int z = 0; z < k; z++)
				//{
					
					
					//for (int y = 0; y <= antallOrdPerKInt; y++;)
					//{
						/*
					    String wordIt = wordsSublists[z][y];
						
					    if (wordIt.equals(givenWord))
						{
						    counterWord ++;	
						}	
				}	
                for (int i = 1; i <= k; i++)
                {
					new Thread(FinnAntall.java().start())
				}					
			//}
						
		}
		
						for (int z = 0; z < k; z++)
				{
					
					
					
					for (int y = 0; y <= antallOrdPerKInt; y++;)
					{
					    String wordIt = wordsSublists[z][y];
					    if (wordIt.equals(givenWord))
						{
						    counterWord ++;	
						}	
				}	
			}	
			System.out.println(counter);
		ExecutorService executor = Executors.newFixedThreadPool(k);
		for (int z = 0; z < k; z++) {
 
			
			Runnable worker = new MyRunnable();
			executor.execute(worker);
		}
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
	}
				*/
				
			//}
			//catch(InterruptedException)
			//{
			    //System.out.prinln("Error");	
			//}
			  //
			
		//}
		//Runnable r = new MyRunnable();
		//Thread t = new Thread(r);
		//t.start();
		}
        catch (FileNotFoundException exception)
		{
		    System.out.println("Could not open input file");
			
			
        }
		
		//public void run();
    }		
}