class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        // find the minimum energy --- we'll keep attacking the minimum enemy, i.e, perform operation 1
        // add the rest of the energies with current energy --- perform operation 2
        // find how many times minimum enemy can be attacked ===> points gained
        if(currentEnergy == 0)
            return 0;
        long minEnergy = Integer.MAX_VALUE;
        long totalEnergy = 0;
        for(int i=0; i<enemyEnergies.length; i++) {
            minEnergy = Math.min(minEnergy, enemyEnergies[i]);
            totalEnergy += enemyEnergies[i];
        }
        
        if(minEnergy > currentEnergy)
            return 0;
        
        // remove the minimum energy from total and add current energy
        totalEnergy -= minEnergy;
        totalEnergy += currentEnergy;
        
        return totalEnergy/minEnergy;
    }
}