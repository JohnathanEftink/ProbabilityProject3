import math
import numpy as np
import matplotlib.pyplot as plot
from scipy.stats import norm
import random

# heavily adapted code from https://github.com/rithik/Newsdrone/tree/master

def big_m_n(n):
    filename = "simdata" + str(n)
    file = open(filename)
    arr = np.fromfile(file,dtype=float, sep=' ')
    mean = np.mean(arr)
    return (arr, mean)

def find_difference(arr):
    cdf_values = [(1-.9192), (1-.8413), (1-.6915), .5, .6915, .8413, .9212]
    diffs = []
    max_diff = 0
    max_index = None
    for k in range(0, len(arr)):
        # print(arr[k])
        diffs.append(abs(cdf_values[k] - arr[k]))
        if diffs[k] > max_diff:
            max_diff = diffs[k]
            max_index = k
        # max_diff = max(max_diff, diffs[k])
    return diffs, max_diff, max_index
    

def small_z_n(n, mean, stddev):
    z_n_arr = []
    arr, avg = big_m_n(n)
    for k in arr:
        z_n_arr.append((k - mean)/(stddev / math.sqrt(n)))
    return z_n_arr

def less_than_z(arr):
    z_values = [-1.4, -1.0, -0.5, 0, 0.5, 1.0, 1.4]
    counts = []
    for i in z_values:
        count = 0
        for j in arr:
            if j <= i:
                count +=1 
        counts.append(count/110)
    return counts

def calculate_all_small_z_n():
    all_values = [10, 30, 50, 100, 250, 500, 1000]
    z_values = [-1.4, -1.0, -0.5, 0, 0.5, 1.0, 1.4]
    mean = 57 * math.sqrt(math.pi/2)
    stddev = math.sqrt((4 - math.pi) / (2 * (1/57)**2))
    norm_x = np.array(np.arange(-2.5, 2.5, 0.01))
    norm_y = [norm.cdf(xa) for xa in norm_x]

    for val in all_values:
        plot.clf()
        data_val = small_z_n(val,mean,stddev)
        cdf_prob_array = less_than_z(data_val)
        print(cdf_prob_array)
        diff_array, MAD, max_idx = find_difference(cdf_prob_array)
        print(val, diff_array, MAD)
        for k in range(0, len(z_values)):
            plot.plot(z_values[k], cdf_prob_array[k], "bo")
     
        plot.vlines(z_values[max_idx], 0, 1)
        # Create the plot
        plot.plot(norm_x, norm_y) 
        plot.xlabel("Z value")
        plot.ylabel("Cumulative Probability")
        plot.title("n = {}".format(val))
        
        plot.savefig('graph{}.png'.format(val))


calculate_all_small_z_n()
