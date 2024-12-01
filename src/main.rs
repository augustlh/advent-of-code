use std::fs::read_to_string;

fn main() {
    let mut i: Vec<i32> = Vec::new();
    let mut j: Vec<i32> = Vec::new();

    for line in read_to_string("src/day1.txt").unwrap().lines() {
        let line_contents: Vec<&str> = line.split_whitespace().collect();
    
        i.push(line_contents[0].parse::<i32>().expect("Failed to parse"));
        j.push(line_contents[1].parse::<i32>().expect("Failed to parse"));
    }

    
    i.sort();
    j.sort();

    let mut res: i32 = 0;

    for idx in 0..i.len() {
        res += (i[idx] - j[idx]).abs();
    }

    println!("{:?}", res);

    //part 2
    //make a hashmap with value from i as key and value as amount of times appearing in j
    //loop over all values, sum key * amount of appeareanses, return
}
