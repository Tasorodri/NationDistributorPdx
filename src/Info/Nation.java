/**
 * 
 */
package Info;

/**
 * @author Taso
 *
 */
public class Nation {

	private String name;
	private int recommendedSkill;
	
	
	public int getRecommendedSkill() {
		return recommendedSkill;
	}


	public String getName() {
		return name;
	}


	public Nation(String name, int recommendedSkill) {
		super();
		this.name = name;
		this.recommendedSkill = recommendedSkill;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
