import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

class Ordre

{
	static int teller = 0;
    public static void main (String[] args) throws FileNotFoundException
    {
		try
		{
			
            File inputFile = new File("data.txt");
		    Scanner in = new Scanner(inputFile);
            Tabell<Personer> TabellPersoner;
            TabellPersoner = new Tabell<Personer>(10);
            Tabell<Legemiddel> TabellLegemiddel;
            TabellLegemiddel = new Tabell<Legemiddel>(10);	
            SortertEnkelListe<Leger> SortertEnkelListeLeger;
            SortertEnkelListeLeger = new SortertEnkelListe<Leger>();
			EnkelReseptListe ReseptListe;
			ReseptListe = new EnkelReseptListe();
			
			
			
			public void read()
			{
				while (in.hasNextLine())
				{
			        String line = in.nextLine();
				    if (line.startsWith("# Personer"))
			        {
			            line = in.nextLine();
					    while (line.length() != 0)
			            {
                            int i = 0;
			                while (!Character.isWhitespace(line.charAt(i))) // Fredrik: feilmelding
			                {
			                    i++;
							}
						    i = i-1;
						    String nummer = line.substring(0,i);
						    int nrInt = Integer.parseInt(nummer);
						    i = i + 2; 
						    int j = i;
						    while (!Character.toString(line.charAt(j)).equals(","))
				            {
					            j++;
				            }	
				            String navn = line.substring(i,j);
                            j = j+ 2;
						    i = j;
						    while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				            String fodselsnr = line.substring(i,j);
						    Personer p = new Personer(navn, fodselsnr);
						    String veinavn= "";
				            String veinummer = "";
				            String postnummer = "";
				            j = j + 2;
						    i = j;
						    while (!Character.isDigit(line.charAt(j))) 
				            {
					            j++;
				            }
                            j = j -1;  
						    veinavn = line.substring(i,j);
						    j = j + 1; 
						    i = j;
						    while (!Character.toString(line.charAt(j)).equals(","))
				            {
					            j++;
				            }
				            veinummer = line.substring(i,j);
						    j = j+2;
						    int lengde = line.length();
				            postnummer = line.substring(j,lengde);
						    p.adresse(veinavn, veinummer, postnummer);
						    TabellPersoner.settInn(nrInt,p);
						    line = in.nextLine();
				        }
				    }
                    else if (line.startsWith(" "))
				    {
					    line = in.nextLine();
				    }	
                    else if (line.startsWith("# Legemidler"))
				    {
					    line = in.nextLine();
					    while (line.length() != 0)
					    {
					        int i = 0;	
						    while (!Character.isWhitespace(line.charAt(i))) // Fredrik: feilmelding
			                {
			                    i++;
			                }
						    i = i-1;
						    String nummer = line.substring(0,i);
						    int intNr = Integer.parseInt(nummer);
						    i = i + 2; 
						    int j = i;
						    while (!Character.toString(line.charAt(j)).equals(","))
				            {
					            j++;
				            }	
				            String navn = line.substring(i,j);
						    j = j+ 2;
						    i = j;
						    while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				            String form = line.substring(i,j);
						    if (form.equals("mikstur"))
						    {
							    j = j+ 2;
						        i = j;
						        while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                String type  = line.substring(i,j);
							    if (type.equals("a"))
							    {
								    String typeA = type;
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String pris = line.substring(i,j);
						            int prisInt = Integer.parseInt(pris);
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String mengde = line.substring(i,j);
						        	int mengdeInt = Integer.parseInt(mengde);
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String virkestoff = line.substring(i,j);
						            int virkestoffInt = Integer.parseInt(virkestoff);
								    j = j+2;
						            int lengde = line.length();
				                    String styrke = line.substring(j,lengde);
								    int styrkeInt = Integer.parseInt(styrke);
								    AMikstur AM1 = new AMikstur(navn, prisInt, styrkeInt);
								    AM1.Mikstur(mengdeInt, virkestoffInt);
								    TabellLegemiddel.settInn(intNr,AM1);
								}
							    if (type.equals("b"))
							    {
								    String typeB = type;
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String pris = line.substring(i,j);
						            int prisInt = Integer.parseInt(pris);
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String mengde = line.substring(i,j);
						            int mengdeInt = Integer.parseInt(mengde);
								    j = j+ 2;
									i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String virkestoff = line.substring(i,j);
						            int virkestoffInt = Integer.parseInt(virkestoff);
								    j = j+2;
						            int lengde = line.length();
				                    String styrke = line.substring(j,lengde);
								    int styrkeInt = Integer.parseInt(styrke);
								    BMikstur BM1 = new BMikstur(navn, prisInt, styrkeInt);
								    BM1.Mikstur(mengdeInt, virkestoffInt);
								    TabellLegemiddel.settInn(intNr,BM1);
								}
							    if (type.equals("c"))
							    {
								    String typeC = type;
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String pris = line.substring(i,j);
						            int prisInt = Integer.parseInt(pris);
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String mengde = line.substring(i,j);
						            int mengdeInt = Integer.parseInt(mengde);
								    j = j+2;
						            int lengde = line.length();
				                    String virkestoff = line.substring(j,lengde);
								    int virkestoffInt = Integer.parseInt(virkestoff);
								    CMikstur CM1 = new CMikstur(navn, prisInt);
								    CM1.Mikstur(mengdeInt, virkestoffInt);
								    TabellLegemiddel.settInn(intNr,CM1);
							    }
							
						    	
						    }
						    else
						    {
							    j = j+ 2;
						        i = j;
						        while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                String type  = line.substring(i,j);
							    if (type.equals("a"))
							    {
								   String typeA = type;
								    j = j+ 2;
						            i = j;
					                while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String pris = line.substring(i,j);
						            int prisInt = Integer.parseInt(pris);
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String mengde = line.substring(i,j);
						           	int mengdeInt = Integer.parseInt(mengde);
								    j = j+ 2;
									i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
                                    String virkestoff = line.substring(i,j);
						            int virkestoffInt = Integer.parseInt(virkestoff);
						            j = j+2;
									int lengde = line.length();
				                    String styrke = line.substring(j,lengde);
								    int styrkeInt = Integer.parseInt(styrke);
								    APiller AP1 = new APiller(navn, prisInt, styrkeInt);
								    AP1.Piller(mengdeInt, virkestoffInt);
								    TabellLegemiddel.settInn(intNr,AP1);
								}
							    if (type.equals("b"))
							    {
								    String typeB = type;
								    j = j+ 2;
						            i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String pris = line.substring(i,j);
						            int prisInt = Integer.parseInt(pris);
								    j = j+ 2;
									i = j;
						            while (!Character.toString(line.charAt(j)).equals(","))
                                    {
					                    j++;
				                    }
				                    String mengde = line.substring(i,j);
						            int mengdeInt = Integer.parseInt(mengde);
								
							
								j = j+ 2;
						        
				                i = j;
						        
					
				               
						     
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				               
				                String virkestoff = line.substring(i,j);
						       
								int virkestoffInt = Integer.parseInt(virkestoff);
							
								j = j+2;
						     
                                int lengde = line.length();
				                String styrke = line.substring(j,lengde);
								
								int styrkeInt = Integer.parseInt(styrke);
								BPiller BP1 = new BPiller(navn, prisInt, styrkeInt);
								BP1.Piller(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,BP1);
							}
							if (type.equals("c"))
							{
								String typeC = type;
								System.out.println(typeC);
								
								j = j+ 2;
						       
				                i = j;
						        
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						       
								int prisInt = Integer.parseInt(pris);
								
								j = j+ 2;
						      
				                i = j;
						        
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				               
				                String mengde = line.substring(i,j);
						     
								int mengdeInt = Integer.parseInt(mengde);
								
								
								j = j+2;
						        
                                int lengde = line.length();
				                String virkestoff = line.substring(j,lengde);
								
								int virkestoffInt = Integer.parseInt(virkestoff);
								CPiller CP1 = new CPiller(navn, prisInt);
								CP1.Piller(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,CP1);
								
								
								
							
								
							}
                    							
							
						}	
						
						
                        line = in.nextLine();						
					}
					
					
                    
                }
                else if (line.startsWith("# Leger"))
                {
					line = in.nextLine();
					
			        while (line.length() != 0)
					{
						int i = 0;	
						int j = i;
						
				
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }	
				        
						
                        String navn = line.substring(i,j);
					
						j = j+ 2;
						       
				        int lengde = line.length();
						String avtalenr = line.substring(j,lengde);
						
						if (avtalenr.equals("0"))
						{
							Leger l = new Leger(navn);
							
							SortertEnkelListeLeger.leggTil(l);
							
							
						}
						else
						{
							Fastlege l = new Fastlege(navn);
							l.Avtalenummer(avtalenr);
							SortertEnkelListeLeger.leggTil(l);
							
						}	
						line = in.nextLine();
						
					}
					
				}
				
                else if (line.startsWith("# Resepter"))
                {
					line = in.nextLine();
					System.out.println(line);
			        while (line.length() != 0)
					{
						int i = 0;	
						
						while (!Character.isWhitespace(line.charAt(i))) 
			            {
			                i++;
			            }
						
				        i = i + 1; 
						
				        int j = i;
						
				
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }	
				        
						
                        String type = line.substring(i,j);
					
						if (type.equals("hvit"))
						{
						    j = j+ 2;
						   
				            i = j;
						
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        
				            String persNr = line.substring(i,j);
							int persNrInt = Integer.parseInt(persNr);
						  
					
							j = j+ 2;
						 
				            i = j;
						
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				      
				            String legeNavn = line.substring(i,j);
						    
							j = j+ 2;
						    
				            i = j;
						
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				     
				            String legemiddelNr = line.substring(i,j);
							
						    
							int legemiddelNrInt = Integer.parseInt(legemiddelNr);
							j = j+2;
						      
                            int lengde = line.length();
				            String reit = line.substring(j,lengde);
							int reitInt = Integer.parseInt(reit);
						  
							Hvit resepten = new Hvit(type, persNrInt,legeNavn, legemiddelNrInt, reitInt);
							ReseptListe.settInn(resepten); 
							
							
							
						
							
							
						}
                        else
                        {
							j = j+ 2;
						    
				            i = j;
						
					
				      
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				      
				            String persNr = line.substring(i,j);
						    System.out.println(persNr+ " personnummer");
							int persNrInt = Integer.parseInt(persNr);
							
							
							
							j = j+ 2;
						    
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String legeNavn = line.substring(i,j);
						    System.out.println(legeNavn+ " legeNavn");
							j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String legemiddelNr = line.substring(i,j);
						    System.out.println(legemiddelNr+ " legemiddelNr");
							int legemiddelNrInt = Integer.parseInt(legemiddelNr);
							j = j+2;
						        //System.out.println(j);
                            int lengde = line.length();
				            String reit = line.substring(j,lengde);
							int reitInt = Integer.parseInt(reit);
						    System.out.println(reit + " reit");
							Blaa resepten = new Blaa(type, persNrInt,legeNavn, legemiddelNrInt, reitInt);
							ReseptListe.settInn(resepten); 
							//l.Avtalenummer(avtalenr);
							//SortertEnkelListeLeger.leggTil(l);
							
						}							
						line = in.nextLine();
						
					}	
						
						
						
						
						
						
						
						
					
				}	
                else if (line.startsWith("# Slutt"))
                {
					line = in.nextLine();
				}					
			}
			in.close();    
			}
			
			
		
            			
		    while (in.hasNextLine())
		    {
			    String line = in.nextLine();
				//System.out.println(line);
			    if (line.startsWith("# Personer"))
			    {
			        //0, Jens Hans Olsen, 11111143521, Veigata 9, 1323
					//# Personer (nr, navn, fnr, adresse, postnr)
//0, Jens Hans Olsen, 11111143521, Veigata 9, 1323
//1, Petrolina Swiq, 24120099343, Pillestedet 49, 0789
//2, Sven Svendsen, 10111224244, Storgata 67, 5341
//3, Juni Olsen, 21049563451, Blåbærstien 423b, 1332
//4, Pernille Pillebruker, 31129942342, Slottspark 1, 0412
//5, Johan-Niclas Ingmarson, 31018253352, Kokveien 782, 4502
//6, Kari Lise Krokstubbakken, 14055423423, Krokstubbakken 1, 7832
//7, Ane Rask, 29117091241, Akebakken 7, 3522
//8, Arne Seberg, 09036842342, Akebakken 7, 3522
//9, Anna Rask Seberg, 01049364352, Akebakken 7, 3522
//10, Inna Tharaldsrud, 14085535087, Jordstjerneveien 17, 1283
                    //static int teller = -1;
					//int nummer = null;
                    line = in.nextLine();
					System.out.println(line);
			        while (line.length() != 0)
			        {
                        //line = in.nextLine();
                        System.out.println(line);						
			            int i = 0;
			            while (!Character.isWhitespace(line.charAt(i))) // Fredrik: feilmelding
			            {
			                i++;
							System.out.println(i);
			            }
						i = i-1;
						System.out.println(i+" hei");
						//System.out.println(i);
				        String nummer = line.substring(0,i);
						int nrInt = Integer.parseInt(nummer);
						//System.out.println(nummer+"nummer");
				        
						//System.out.println(nr);
				        i = i + 2; 
						//System.out.println(i);
				        int j = i;
						//System.out.println(j);
				        //char c = line.charAt(j);
				        //String c = Character.toString(line.charAt(j));
						//System.out.println(c);
				
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }	
				        
						//System.out.println(j);
						//System.out.println(j);
                        String navn = line.substring(i,j);
                        //System.out.println(name);						
                        //long fodselsnummer = 0L;
                        j = j+ 2;
						//System.out.println(j);
				        i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				        while (!Character.toString(line.charAt(j)).equals(","))
                        {
					        j++;
				        }
				        //j = j-2;
				        String fodselsnr = line.substring(i,j);
						Personer p = new Personer(navn, fodselsnr);
						//System.out.println(fodselsnr);
				        //fodselsnummer = Long.parseLong(fodselsnr);
						//System.out.println(fodselsnummer);
				        String veinavn= "";
				        String veinummer = "";
				        String postnummer = "";
				        j = j + 2;
						//System.out.println(j);
				        i = j;
						//System.out.println(i);
				        while (!Character.isDigit(line.charAt(j))) 
				        {
					        j++;
				        }
                        j = j -1;  
						//System.out.println(j);
				        veinavn = line.substring(i,j);
						//System.out.println(j);
						//System.out.println(veinavn);
				        j = j + 1; 
						//System.out.println(j);
				        i = j;
						//System.out.println(i);
				       // c = Character.toString(line.charAt(j));
						//System.out.println(c);
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }
				        //j = j -1;
						//System.out.println(j);
                        veinummer = line.substring(i,j);
						//System.out.println(veinummer+ "veinummer");
				        //int veinr = Integer.parseInt(veinummer);
                        j = j+2;
						//System.out.println(j);
                        int lengde = line.length();
				        postnummer = line.substring(j,lengde);
						p.adresse(veinavn, veinummer, postnummer);
						TabellPersoner.settInn(nrInt,p);
						//System.out.println(postnummer);
						line = in.nextLine();
				        
						
				
			        }
				}
                else if (line.startsWith(" "))
				{
					
				    line = in.nextLine();
				}	
                else if (line.startsWith("# Legemidler"))
				{
					
					line = in.nextLine();
					System.out.println(line);
					
			        while (line.length() != 0)
					{
					    int i = 0;	
						//System.out.println(postnummer);
				        //int postnr = Integer.parseInt(postnummer);
						while (!Character.isWhitespace(line.charAt(i))) // Fredrik: feilmelding
			            {
			                i++;
			            }
						i = i-1;
						//System.out.println(i);
				        String nummer = line.substring(0,i);
						int intNr = Integer.parseInt(nummer);
						System.out.println(nummer);
						//System.out.println(nummer+"nummer");
				        
						//System.out.println(nr);
				        i = i + 2; 
						//System.out.println(i);
				        int j = i;
						//System.out.println(j);
				        //char c = line.charAt(j);
				        //String c = Character.toString(line.charAt(j));
						//System.out.println(c);
				
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }	
				        
						//System.out.println(j);
						//System.out.println(j);
                        String navn = line.substring(i,j);
						System.out.println(navn);
						j = j+ 2;
						//System.out.println(j);
				        i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				        while (!Character.toString(line.charAt(j)).equals(","))
                        {
					        j++;
				        }
				        //j = j-2;
				        String form = line.substring(i,j);
						System.out.println(form);
						if (form.equals("mikstur"))
						{
							j = j+ 2;
						//System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String type  = line.substring(i,j);
							System.out.println(type);
							if (type.equals("a"))
							{
								String typeA = type;
								System.out.println(typeA+"yeah");
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						        System.out.println(pris+" pris");
								int prisInt = Integer.parseInt(pris);
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String mengde = line.substring(i,j);
						        System.out.println(mengde+" mengde");
								int mengdeInt = Integer.parseInt(mengde);
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String virkestoff = line.substring(i,j);
						        System.out.println(virkestoff+" virkestoff");
								int virkestoffInt = Integer.parseInt(virkestoff);
								// Convert to integer   !!!!!!
								j = j+2;
						        //System.out.println(j);
                                int lengde = line.length();
				                String styrke = line.substring(j,lengde);
								System.out.println(styrke + " styrke");
								int styrkeInt = Integer.parseInt(styrke);
								AMikstur AM1 = new AMikstur(navn, prisInt, styrkeInt);
								AM1.Mikstur(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,AM1);
								
								//TabellLegemiddel.settInn(AM1);
								
								
								
							
								// Convert to integer   !!!!!!
								
						        //p.adresse(veinavn, veinummer, postnummer);
						        //TabellPersoner.settInn(teller++,p);
						        //System.out.println(postnummer);
						        
								
								
								
								
								//j = j+ 2;
						        //System.out.println(j);
				               // i = j;
								
								
								
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
								
							}
							if (type.equals("b"))
							{
								String typeB = type;
								System.out.println(typeB);
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						        System.out.println(pris+" pris");
								int prisInt = Integer.parseInt(pris);
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String mengde = line.substring(i,j);
						        System.out.println(mengde+" mengde");
								int mengdeInt = Integer.parseInt(mengde);
								
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String virkestoff = line.substring(i,j);
						        System.out.println(virkestoff+" virkestoff");
								int virkestoffInt = Integer.parseInt(virkestoff);
								// Convert to integer   !!!!!!
								j = j+2;
						        //System.out.println(j);
                                int lengde = line.length();
				                String styrke = line.substring(j,lengde);
								System.out.println(styrke + " styrke");
								int styrkeInt = Integer.parseInt(styrke);
								BMikstur BM1 = new BMikstur(navn, prisInt, styrkeInt);
								BM1.Mikstur(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,BM1);
								
								
								
							
								// Convert to integer   !!!!!!
								
						        //p.adresse(veinavn, veinummer, postnummer);
						        //TabellPersoner.settInn(teller++,p);
						        //System.out.println(postnummer);
						        
								
								
								
								
								//j = j+ 2;
						        //System.out.println(j);
				               // i = j;
								
								
								
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
							}
							if (type.equals("c"))
							{
								String typeC = type;
								System.out.println(typeC);
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						        System.out.println(pris+" pris");
								int prisInt = Integer.parseInt(pris);
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String mengde = line.substring(i,j);
						        System.out.println(mengde+" mengde");
								int mengdeInt = Integer.parseInt(mengde);
								
								// Convert to integer   !!!!!!
								j = j+2;
						        //System.out.println(j);
                                int lengde = line.length();
				                String virkestoff = line.substring(j,lengde);
								System.out.println(virkestoff + " virkestoff");
								int virkestoffInt = Integer.parseInt(virkestoff);
								CMikstur CM1 = new CMikstur(navn, prisInt);
								CM1.Mikstur(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,CM1);
								
								
								
							
								// Convert to integer   !!!!!!
								
						        //p.adresse(veinavn, veinummer, postnummer);
						        //TabellPersoner.settInn(teller++,p);
						        //System.out.println(postnummer);
						        
								
								
								
								
								//j = j+ 2;
						        //System.out.println(j);
				               // i = j;
								
								
								
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
							}
							
						    	
						}
							
						else
						{
							j = j+ 2;
						//System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String type  = line.substring(i,j);
							System.out.println(type); 
							if (type.equals("a"))
							{
								String typeA = type;
								System.out.println(typeA);
								//String typeA = type;
								System.out.println(typeA+"yeah");
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						        System.out.println(pris+" pris");
								int prisInt = Integer.parseInt(pris);
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String mengde = line.substring(i,j);
						        System.out.println(mengde+" mengde");
								int mengdeInt = Integer.parseInt(mengde);
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String virkestoff = line.substring(i,j);
						        System.out.println(virkestoff+" virkestoff");
								int virkestoffInt = Integer.parseInt(virkestoff);
								// Convert to integer   !!!!!!
								j = j+2;
						        //System.out.println(j);
                                int lengde = line.length();
				                String styrke = line.substring(j,lengde);
								System.out.println(styrke + " styrke");
								int styrkeInt = Integer.parseInt(styrke);
								APiller AP1 = new APiller(navn, prisInt, styrkeInt);
								AP1.Piller(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,AP1);
								
								
								
							
								// Convert to integer   !!!!!!
								
						        //p.adresse(veinavn, veinummer, postnummer);
						        //TabellPersoner.settInn(teller++,p);
						        //System.out.println(postnummer);
						        
								
								
								
								
								//j = j+ 2;
						        //System.out.println(j);
				               // i = j;
								
								
								
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
							}
							if (type.equals("b"))
							{
								String typeB = type;
								System.out.println(typeB);
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						        System.out.println(pris+" pris");
								int prisInt = Integer.parseInt(pris);
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String mengde = line.substring(i,j);
						        System.out.println(mengde+" mengde");
								int mengdeInt = Integer.parseInt(mengde);
								
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String virkestoff = line.substring(i,j);
						        System.out.println(virkestoff+" virkestoff");
								int virkestoffInt = Integer.parseInt(virkestoff);
								// Convert to integer   !!!!!!
								j = j+2;
						        //System.out.println(j);
                                int lengde = line.length();
				                String styrke = line.substring(j,lengde);
								System.out.println(styrke + " styrke");
								int styrkeInt = Integer.parseInt(styrke);
								BPiller BP1 = new BPiller(navn, prisInt, styrkeInt);
								BP1.Piller(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,BP1);
							}
							if (type.equals("c"))
							{
								String typeC = type;
								System.out.println(typeC);
								//String typeC = type;
								//System.out.println(typeC);
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String pris = line.substring(i,j);
						        System.out.println(pris+" pris");
								int prisInt = Integer.parseInt(pris);
								// Convert to integer   !!!!!!
								j = j+ 2;
						        //System.out.println(j);
				                i = j;
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
				                while (!Character.toString(line.charAt(j)).equals(","))
                                {
					                j++;
				                }
				                //j = j-2;
				                String mengde = line.substring(i,j);
						        System.out.println(mengde+" mengde");
								int mengdeInt = Integer.parseInt(mengde);
								
								// Convert to integer   !!!!!!
								j = j+2;
						        //System.out.println(j);
                                int lengde = line.length();
				                String virkestoff = line.substring(j,lengde);
								System.out.println(virkestoff + " virkestoff");
								int virkestoffInt = Integer.parseInt(virkestoff);
								CPiller CP1 = new CPiller(navn, prisInt);
								CP1.Piller(mengdeInt, virkestoffInt);
								TabellLegemiddel.settInn(intNr,CP1);
								
								
								
							
								// Convert to integer   !!!!!!
								
						        //p.adresse(veinavn, veinummer, postnummer);
						        //TabellPersoner.settInn(teller++,p);
						        //System.out.println(postnummer);
						        
								
								
								
								
								//j = j+ 2;
						        //System.out.println(j);
				               // i = j;
								
								
								
						        //System.out.println(i);
					
				                //c = Character.toString(line.charAt(j));
						        //System.out.println(c);
							}
                    							
							
						}	
						
						
                        line = in.nextLine();						
					}
					
					
                    
                }
                else if (line.startsWith("# Leger"))
                {
					line = in.nextLine();
					System.out.println(line);
			        while (line.length() != 0)
					{
						int i = 0;	
						int j = i;
						
				
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }	
				        
						//System.out.println(j);
						//System.out.println(j);
                        String navn = line.substring(i,j);
						System.out.println(navn+ " legenavn");
						j = j+ 2;
						        //System.out.println(j);
				        int lengde = line.length();
						String avtalenr = line.substring(j,lengde);
						System.out.println(avtalenr);
						if (avtalenr.equals("0"))
						{
							Leger l = new Leger(navn);
							//l.Leger(navn);
							SortertEnkelListeLeger.leggTil(l);
							
							
						}
						else
						{
							Fastlege l = new Fastlege(navn);
							l.Avtalenummer(avtalenr);
							SortertEnkelListeLeger.leggTil(l);
							
						}	
						line = in.nextLine();
						
					}
					
				}
				//# Resepter (nr, hvit/blaa, persNummer, legeNavn, legemiddelNummer, reit)
                //0, blaa, 4, Dr. Oz, 2, 2
                //1, blaa, 0, Dr. Phil, 1, 3
                //2, hvit, 4, Dr. Dre, 2, 0
                 //3, hvit, 4, Dr. Cox, 2, 0
                else if (line.startsWith("# Resepter"))
                {
					line = in.nextLine();
					System.out.println(line);
			        while (line.length() != 0)
					{
						int i = 0;	
						//System.out.println(postnummer);
				        //int postnr = Integer.parseInt(postnummer);
						while (!Character.isWhitespace(line.charAt(i))) // Fredrik: feilmelding
			            {
			                i++;
			            }
						//i = i-1;
						//System.out.println(i);
				        //String nummer = line.substring(0,i);
						//System.out.println(nummer);
						//System.out.println(nummer+"nummer");
				        
						//System.out.println(nr);
				        i = i + 1; 
						//System.out.println(i);
				        int j = i;
						//System.out.println(j);
				        //char c = line.charAt(j);
				        //String c = Character.toString(line.charAt(j));
						//System.out.println(c);
				
				        while (!Character.toString(line.charAt(j)).equals(","))
				        {
					        j++;
				        }	
				        
						//System.out.println(j);
						//System.out.println(j);
                        String type = line.substring(i,j);
						System.out.println(type + " type");
						if (type.equals("hvit"))
						{
						    j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String persNr = line.substring(i,j);
							int persNrInt = Integer.parseInt(persNr);
						    System.out.println(persNr+ " personnummer");
							//
							j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String legeNavn = line.substring(i,j);
						    System.out.println(legeNavn+ " legeNavn");
							j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String legemiddelNr = line.substring(i,j);
							
						    System.out.println(legemiddelNr+ " legemiddelNr");
							int legemiddelNrInt = Integer.parseInt(legemiddelNr);
							j = j+2;
						        //System.out.println(j);
                            int lengde = line.length();
				            String reit = line.substring(j,lengde);
							int reitInt = Integer.parseInt(reit);
						    System.out.println(reit + " reit");
							Hvit resepten = new Hvit(type, persNrInt,legeNavn, legemiddelNrInt, reitInt);
							ReseptListe.settInn(resepten); 
							
							
							
							//YngsteForstReseptListePerson.settInn()
							
							
						}
                        else
                        {
							j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String persNr = line.substring(i,j);
						    System.out.println(persNr+ " personnummer");
							int persNrInt = Integer.parseInt(persNr);
							//TabellPersoner.finn(persNrInt);
							//YngsteForstReseptListePerson.settInn()
							
							
							//
							j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String legeNavn = line.substring(i,j);
						    System.out.println(legeNavn+ " legeNavn");
							j = j+ 2;
						    //System.out.println(j);
				            i = j;
						//System.out.println(i);
					
				        //c = Character.toString(line.charAt(j));
						//System.out.println(c);
				            while (!Character.toString(line.charAt(j)).equals(","))
                            {
					            j++;
				            }
				        //j = j-2;
				            String legemiddelNr = line.substring(i,j);
						    System.out.println(legemiddelNr+ " legemiddelNr");
							int legemiddelNrInt = Integer.parseInt(legemiddelNr);
							j = j+2;
						        //System.out.println(j);
                            int lengde = line.length();
				            String reit = line.substring(j,lengde);
							int reitInt = Integer.parseInt(reit);
						    System.out.println(reit + " reit");
							Blaa resepten = new Blaa(type, persNrInt,legeNavn, legemiddelNrInt, reitInt);
							ReseptListe.settInn(resepten); 
							//l.Avtalenummer(avtalenr);
							//SortertEnkelListeLeger.leggTil(l);
							
						}							
						line = in.nextLine();
						
					}	
						
						
						
						
						
						
						
						
					
				}	
                else if (line.startsWith("# Slutt"))
                {
					line = in.nextLine();
				}					
			}
			in.close();
			String outFile = "data2.txt";
			PrintWriter out = new PrintWriter(outFile);
			out.print("# Personer (nr, navn, fnr, adresse, postnr)\n");
			Iterator i = TabellPersoner.iterator();
			while (i.hasNext())
			{
				Object p = i.next();
				Personer p1 = (Personer) p;
				out.print(p.toString()+"\n");
			}
			out.print("\n");
			out.print("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])\n");
			Iterator j = TabellLegemiddel.iterator();
			while (j.hasNext())
			{
				Object l = i.next();
				Legemiddel l1 = (Legemiddel) l;
				out.print(l1.toString()+"\n");
			}
			out.print("\n");
			out.print("# Leger (navn, avtalenr / 0 hvis ingen avtale)\n");
			i = SortertEnkelListeLeger.iterator();
			while (i.hasNext())
			{
				Object le = i.next();
				Leger le1 = (Leger) le;
				out.print(le1.toString()+"\n");
			}
			out.print("\n");
			out.print("# Resepter (nr, hvit/blå, persNummer, legeNavn, legemiddelNummer, reit)\n");
			i = ReseptListe.iterator();
			while (i.hasNext())
			{
				Object r = i.next();
				Resepter r1 = (Resepter) r;
				out.print(r1.toString()+"\n");
			}
			out.print("\n");
			out.print("# Slutt");
			out.close();
			
			System.out.println("# Personer (nr, navn, fnr, adresse, postnr)\n");
			i = TabellPersoner.iterator();
			while (i.hasNext())
			{
				Object p = i.next();
				Personer p1 = (Personer) p;
				System.out.println(p.toString()+"\n");
			}
			System.out.println("\n");
			System.out.println("# Legemidler (nr, navn, form, type, pris, antall/mengde, virkestoff [, styrke])\n");
			j = TabellLegemiddel.iterator();
			while (j.hasNext())
			{
				Object l = i.next();
				Legemiddel l1 = (Legemiddel) l;
				System.out.println(l1.toString()+"\n");
			}
			System.out.println("\n");
			System.out.println("# Leger (navn, avtalenr / 0 hvis ingen avtale)\n");
			i = SortertEnkelListeLeger.iterator();
			while (i.hasNext())
			{
				Object le = i.next();
				Leger le1 = (Leger) le;
				System.out.println(le1.toString()+"\n");
			}
			System.out.println("\n");
			System.out.println("# Resepter (nr, hvit/blå, persNummer, legeNavn, legemiddelNummer, reit)\n");
			i = ReseptListe.iterator();
			while (i.hasNext())
			{
				Object r = i.next();
				Resepter r1 = (Resepter) r;
				System.out.println(r1.toString()+"\n");
			}
			System.out.println("\n");
			System.out.println("# Slutt");
			
			
			
			
			
			
			
			
			
		}
        catch (FileNotFoundException exception)
		{
		    System.out.println("Could not open input file");
            
			
		}
			
			
		
		
		    
			    
	}
}	
	
    
			
			
		
		
				 