import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map.*;
  
  /*
   * To execute Java, please define "static void main" on a class
   * named Solution.
   *
   * If you need more classes, simply define them inline.
   */
  
  
  class Solution {
    
    static private  int MAXCAP = 5;
     
    public static void main(String[] args) {
      ArrayList<String> strings = new ArrayList<String>();
      Object wordFrequency = null;
      Object sortedWords = null;
      
      /*********************
      Question 1 - given the static string ' chapter ' (see below), count the number of words in the paragraph. Please ignore case and skips words found in the ' stopWords ' list provided 
      **********************/
        
      wordFrequency = countNumberOfWords( chapter, stopWords);
      
      
      
      /*********************
      Question 2 - Take the wordFrequency object from question 1 and sort from most commonly seen words to least common.  
      **********************/ 
      
      sortedWords = sortMostFrequentWords( wordFrequency, stopWords);
          
      
      
      /********************* 
      Question 3 - Print all words from the sortedWords object in question 2 that are in the top 5 most frequent words. There will likely be more than 5 words in the final list as different words may appear at the same frequency. Example: Output below shows more than 5 words as the 5th most common word is tied by 5 different words. 
      
      Example output
      --------------
       ambergris = 8
       out = 7
       whale = 6
       found = 5
       whales = 4
       amber = 4
       oil = 4
       such = 4
       now = 4
  
    **********************/
      
      printTopWords(sortedWords, MAXCAP);  
    
    }
    
  
     
    
    
  
    static Object countNumberOfWords(String document, List<String> stopWords ){
      HashMap<String, Integer> hm = new HashMap<>();
      
      document = document.replaceAll("[!?,;.']", "").toLowerCase();
      
      String[] newDoc = document.split("\\s+");
      
      for (String s: newDoc) {
        if (stopWords.contains(s)){
          continue;
        }
        
        if (hm.containsKey(s)) {
          hm.put(s, hm.get(s) + 1);
        } else {
          hm.put(s, 1);
        }
        
      }
      
      
      return hm;
      
    }
    
     static Object sortMostFrequentWords(Object wordToCount,Object stopWords){
        Set<Entry<String, Integer>> set = ((HashMap<String, Integer>) wordToCount).entrySet();
       
       List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
       Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
        public int compare(Map.Entry<String, Integer> v1, Map.Entry<String, Integer> v2) {
          return (v2.getValue()).compareTo(v1.getValue());  
        } 
         
       });
                        
        
                        
                    
          return list;
    }
    
    static void printTopWords(Object sortedWords, int cap){  
      HashSet<Integer> hs = new HashSet<>();
      
      int i = 0;
      
      List<Entry<String, Integer>> list = (List<Entry<String, Integer>>) sortedWords;
      while (i < list.size()) {
        
        
        hs.add(list.get(i).getValue());
        
        if (hs.size() > cap) {
          break;
        }
          
        System.out.println(list.get(i).getKey() + " = " + list.get(i).getValue());     
        
        i += 1;
        
      }
        
    }
    
    
  
  
  
  static List<String> stopWords = Arrays.asList("the", "of", "in", "that", "to", "a", "is", "and", "it", "for", "as", "be", "but", "this", "by", "which", "with", "at", "on", "an", "or", "what", "are", "how", "do", "then", "than", "so", "not", "were", "some", "did", "i", "you", "them", "we", "he", "she", "her", "him", "also", "was");
  
  static String chapter = "Now this ambergris is a very curious substance, and so important as an article of commerce, that in 1791 a certain Nantucket-born Captain Coffin was examined at the bar of the English House of Commons on that subject. For at that time, and indeed until a comparatively late day, the precise origin of ambergris remained, like amber itself, a problem to the learned. Though the word ambergris is but the French compound for grey amber, yet the two substances are quite distinct. For amber, though at times found on the sea-coast, is also dug up in some far inland soils, whereas ambergris is never found except upon the sea. Besides, amber is a hard, transparent, brittle, odorless substance, used for mouth-pieces to pipes, for beads and ornaments; but ambergris is soft, waxy, and so highly fragrant and spicy, that it is largely used in perfumery, in pastiles, precious candles, hair-powders, and pomatum. The Turks use it in cooking, and also carry it to Mecca, for the same purpose that frankincense is carried to St. Peter’s in Rome. Some wine merchants drop a few grains into claret, to flavor it. Who would think, then, that such fine ladies and gentlemen should regale themselves with an essence found in the inglorious bowels of a sick whale! Yet so it is. By some, ambergris is supposed to be the cause, and by others the effect, of the dyspepsia in the whale. How to cure such a dyspepsia it were hard to say, unless by administering three or four boat loads of Brandreth’s pills, and then running out of harm’s way, as laborers do in blasting rocks. I have forgotten to say that there were found in this ambergris, certain hard, round, bony plates, which at first Stubb thought might be sailors’ trowsers buttons; but it afterwards turned out that they were nothing more than pieces of small squid bones embalmed in that manner. Now that the incorruption of this most fragrant ambergris should be found in the heart of such decay; is this nothing? Bethink thee of that saying of St. Paul in Corinthians, about corruption and incorruption; how that we are sown in dishonor, but raised in glory. And likewise call to mind that saying of Paracelsus about what it is that maketh the best musk. Also forget not the strange fact that of all things of ill-savor, Cologne-water, in its rudimental manufacturing stages, is the worst. I should like to conclude the chapter with the above appeal, but cannot, owing to my anxiety to repel a charge often made against whalemen, and which, in the estimation of some already biased minds, might be considered as indirectly substantiated by what has been said of the Frenchman’s two whales. Elsewhere in this volume the slanderous aspersion has been disproved, that the vocation of whaling is throughout a slatternly, untidy business. But there is another thing to rebut. They hint that all whales always smell bad. Now how did this odious stigma originate? I opine, that it is plainly traceable to the first arrival of the Greenland whaling ships in London, more than two centuries ago. Because those whalemen did not then, and do not now, try out their oil at sea as the Southern ships have always done; but cutting up the fresh blubber in small bits, thrust it through the bung holes of large casks, and carry it home in that manner; the shortness of the season in those Icy Seas, and the sudden and violent storms to which they are exposed, forbidding any other course. The consequence is, that upon breaking into the hold, and unloading one of these whale cemeteries, in the Greenland dock, a savor is given forth somewhat similar to that arising from excavating an old city grave-yard, for the foundations of a Lying-in Hospital. I partly surmise also, that this wicked charge against whalers may be likewise imputed to the existence on the coast of Greenland, in former times, of a Dutch village called Schmerenburgh or Smeerenberg, which latter name is the one used by the learned Fogo Von Slack, in his great work on Smells, a text-book on that subject. As its name imports (smeer, fat; berg, to put up), this village was founded in order to afford a place for the blubber of the Dutch whale fleet to be tried out, without being taken home to Holland for that purpose. It was a collection of furnaces, fat-kettles, and oil sheds; and when the works were in full operation certainly gave forth no very pleasant savor. But all this is quite different with a South Sea Sperm Whaler; which in a voyage of four years perhaps, after completely filling her hold with oil, does not, perhaps, consume fifty days in the business of boiling out; and in the state that it is casked, the oil is nearly scentless. The truth is, that living or dead, if but decently treated, whales as a species are by no means creatures of ill odor; nor indeed can the whale possibly be otherwise than fragrant, when, as a general thing, he enjoys such high health; taking abundance of exercise; always out of doors; though, it is true, seldom in the open air. I say, that the motion of a Sperm Whale’s flukes above water dispenses a perfume, as when a musk-scented lady rustles her dress in a warm parlor. What then shall I liken the Sperm Whale to for fragrance, considering his magnitude? Must it not be to that famous elephant, with jewelled tusks, and redolent with myrrh, which was led out of an Indian town to do honor to Alexander the Great?";
    
  }
  
  
  
  


