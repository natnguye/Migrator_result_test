

package require Tcl 8.6

proc power_func {base exponent} {
    if {$exponent == 0} {
        return 1
    }
    if {$base == 0 && $exponent < 0} {
        error "Base cannot be 0 with negative exponent"
    }
    if {$exponent < 0} {
        set base [expr {1.0 / $base}]
        set exponent [expr {-1 * $exponent}]
    }
    if {[string is integer $base] == 0} {
        error "Non-integer base is not supported"
    }
    set result 1
    for {set iteration 0} {$iteration < $exponent} {incr iteration} {
        puts "Iteration $iteration/$exponent: result = $result"
        set result [expr {$result * $base}]
    }
    return $result
}

proc extract_file_details_adapter_agent {metadata} {
    set file_type "TCL_SCRIPT"
    set file_type_details "This file contains a TCL script with a procedure definition for calculating the power of a number."
    set file_name "main.tcl"
    set package "N/A"
    set language "TCL"
    set dependencies []
    set importable_elements [list [list name "power_func" fully_qualified_name "power_func"]]
    return [list metadata [list file_type $file_type file_type_details $file_type_details file_name $file_name package $package language $language dependencies $dependencies importable_elements $importable_elements]]
}

set base 2
set exponent 8
set result [power_func $base $exponent]
puts $result
puts "Power($base, $exponent) = $result"