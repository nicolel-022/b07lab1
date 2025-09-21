        class Polynomial {
        	double[] coeffs;
        	
        	// Constructors
        	public Polynomial() {
        		coeffs = new double[1];
        		coeffs[0] = 0;
        	}
        	
        	public Polynomial(double[] arr) {
        	    coeffs = new double[arr.length];
        		for (int i=0; i<arr.length; i++) {
        			coeffs[i] = arr[i];
        		}
        	}
        	
        	// Methods
        	public Polynomial add(Polynomial arr) {
        	    // Compare sizes - take the larger one
        	    int size;
        	    double[] temp;
        	    if (arr.coeffs.length >= this.coeffs.length) {
        	        size = arr.coeffs.length; 
        	        temp = new double[size];
        	        for (int i=0; i<size; i++){
        	            temp[i] = arr.coeffs[i];
        	        }
        	        // Create new Polynomial object
        		    Polynomial sum = new Polynomial(temp);
        		    int i=0;
        		    while (i<this.coeffs.length) {
        			    sum.coeffs[i] = sum.coeffs[i] + this.coeffs[i];
        			    i++;
        	    	}
        		    return sum;
        	    }
        	    else {
        	        size = this.coeffs.length; 
        	        temp = new double[size];
        	        for (int i=0; i<size; i++){
        	            temp[i] = this.coeffs[i];
        	        }
        	        // Create new Polynomial object
        		    Polynomial sum = new Polynomial(temp);
        		    int i=0;
        		    while (i<arr.coeffs.length) {
        			    sum.coeffs[i] = sum.coeffs[i] + arr.coeffs[i];
        			    i++;
        	    	}
        		    return sum;
        	    }
        	}
        
        	public double evaluate(double input) {
        		double out = 0;
        		for (int i=0; i<this.coeffs.length; i++) {
        			// Add the constant
        			if (i == 0){
        				out = out + this.coeffs[0];
        			}
        			// Evaluate rest of polynomial: this[i] * input**i
        			else {
        				out = out + (this.coeffs[i] * Math.pow(input, i));
        			}
        		}
        		return out;
        	}	
        
        	public boolean hasRoot(double val) {
        		double out = evaluate(val);
        		if (out == 0.0) return true;
        		else return false;
        	}
        }