struct Item{
	int value,weight;
};

bool comp(Item a,Item b){
	double r1= (double)a.value/(double)a.weight;
	double r2= (double)b.value/(double)b.weight;
	
	return r1>r2;

}

double knapsack(int W,Item arr[],int n){
	sort(arr,arr+n,comp);
	
	int curWeight=0;
	double finalValue=0.0;
	
	for(int i=0;i<n;i++){
		if(curWeight+arr[i].weight<=W){
			curWeight+=arr[i].weight;
			finalValue=+=arr[i].value;
		}
		else{
			int remain=W- curWeight;
			finalValue=+=(arr[i].value / (double)arr[i].weight)* (double)remain;
			break;
		}
	}
	return finalVslue;
}
