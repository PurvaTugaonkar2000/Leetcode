class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];
        for(int[] log: logs){
            population[log[0] - 1950] += 1;
            population[log[1] - 1950] -= 1;  
        }
        int maxpop = population[0];
        int maxyear = 1950;
        for(int i = 1; i < 101; i++){
            population[i] += population[i - 1];
            if(population[i] > maxpop){
                maxpop = population[i];
                maxyear = i + 1950;
            }
        }
        return maxyear;
    }
}