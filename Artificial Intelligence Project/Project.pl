% Project - CSC429/629 Spring 2020 - Points: 10
% Due: 11:59 pm, April 21
% Lateness penalty: -2 per day

% This is a 1 or 2 person assignment. Type your name(s) below:
% 1. Dillon Koonce
% 2.
% If 2 persons work on this, both of you should submit a
% duplicate copy on Canvas under each of your names.
% You may not collaborate with anyone except your partner.
% By submitting this assignment, you implicitly agree to abide
% by the Computer Science Department Academic Integrity Policy.

% DO NOT USE THESE PROLOG FEATURES IN THIS ASSIGNMENT!! YOU
% WILL NOT RECEIVE CREDIT FOR A SOLUTION CONTAINING THESE:
% ";", "->". Do not use "assert" in the part of the program
% that uses the BN; "assert" should be used only to assert
% facts used by the forward chaining rules.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% What to turn in:
%    Submit a copy of your program on Canvas named project.txt.
%    The digital copy will be used in case the grader needs to
%    run your program to verify that it works, and to determine
%    the submission time if late.  Each student on a team should
%    submit a duplicate copy on Canvas under his/her own name.
%    (Include screen shots with your Design Document.)

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Problem: For a detailed description of the project requirements
% see project-2020-online on Canvas.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Edit this file - add your solution to the steps below.
% Make your solution readable using indentation and white
% space. Do not use a line length that will wrap when printed.
% To run this file, rename it with a .pl extension if your are
% using SWI Prolog, or the proper extension for whatever Prolog
% you are using - you may use any standard Prolog interpreter.
% Follow these instructions for running HW5:
%   1. Copy fig15_11_mod.pl (my mod of Bratko's BN interpreter)
%      from Canvas to your computer.
%   2. Copy fig15_7_mod_1.6.17.pl (my version of Bratko's FC rule
%      interpreter) from Canvas to your computer.
%   3. Start Prolog on your program. Before running your
%      program, tell Prolog to consult fig15_11_mod.pl and
%      fig15_7_mod_1.6.17.pl (in SWI Prolog, you would use menu
%      commands: Filemenu -> Consult -> ... )
%   4. Warning: if you run the FC rules more than once,
%      retract the facts, or just QUIT prolog and start
%      over to flush the facts from memory.

%% HW2&3 Directives (must be at top of SWI Prolog program)
%  Syntax may differ in other Prolog interpreters.
:- dynamic fact(1) .
:- dynamic p/2.
:- dynamic p/3.

% Operator definitions for forward chaining if-then rules.
:- op(800,fx,if).
:- op(700,xfx,then).
:- op(300,xfy,or).
:- op(200,xfy,and).

% Step 1:  Define the BN graph using the syntax required by
% Bratko's BN interpreter as in HW3.
% For pulled muscle.
parent(warmup, pulled_muscle).
parent(flexibility, pulled_muscle).
parent(fall, pulled_muscle).
% For broken bone.
parent(fall, bone_break).
parent(car_acc, bone_break).
parent(overuse, bone_break).
% For torn muscle.
parent(vuln_pos, torn_muscle).
parent(fall, torn_muscle).
parent(weights, torn_muscle).

% Step 2: Define the BN prior probabilities here as in HW3

p(warmup, 0.10).
p(flexibility, 0.10).
p(fall, 0.10).
p(car_acc, 0.10).
p(overuse, 0.10).
p(vuln_pos, 0.10).
p(weights, 0.10).

% Step 3: Define BN conditional probability tables here as in HW3
% For pulled muscle.

% Was no warmup the cause?
p(warm, [warmup, flexibility, fatigue], 0.001).
p(warm, [warmup, not(flexibility), fatigue], 0.001).
p(warm, [warmup, flexibility, not(fatigue)], 0.001).
p(warm, [warmup, not(flexibility), not(fatigue)], 0.001).
p(warm, [not(warmup), flexibility, fatigue], 0.50).
p(warm, [not(warmup), not(flexibility), fatigue], 0.33).
p(warm, [not(warmup), flexibility, not(fatigue)], 0.99).
p(warm, [not(warmup), not(flexibility), not(fatigue)], 0.50).

% Was poor flexibility the cause?
p(flex, [flexibility, warmup, fatigue], 0.001).
p(flex, [flexibility, not(warmup), fatigue], 0.001).
p(flex, [flexibility, warmup, not(fatigue)], 0.001).
p(flex, [flexibility, not(warmup), not(fatigue)], 0.001).
p(flex, [not(flexibility), warmup, fatigue], 0.50).
p(flex, [not(flexibility), not(warmup), fatigue], 0.33).
p(flex, [not(flexibility), warmup, not(fatigue)], 0.99).
p(flex, [not(flexibility), not(warmup), not(fatigue)], 0.50).
% Was fatigue the cause?
p(fat, [fatigue, warmup, flexibility], 0.99).
p(fat, [fatigue, not(warmup), flexibility], 0.50).
p(fat, [fatigue, warmup, not(flexibility)], 0.50).
p(fat, [fatigue, not(warmup), not(flexibility)], 0.33).
p(fat, [not(fatigue), warmup, flexibility], 0.001).
p(fat, [not(fatigue), not(warmup), flexibility], 0.001).
p(fat, [not(fatigue), warmup, not(flexibility)], 0.001).
p(fat, [not(fatigue), not(warmup), not(flexibility)], 0.001).

% For Broken Bone.
% Was a car accident the cause?
p(car, [car_acc, fall, overuse], 0.33).
p(car, [car_acc, not(fall), overuse], 0.50).
p(car, [car_acc, fall, not(overuse)], 0.50).
p(car, [car_acc, not(fall), not(overuse)], 0.99).
p(car, [not(car_acc), fall, overuse], 0.001).
p(car, [not(car_acc), not(fall), overuse], 0.001).
p(car, [not(car_acc), fall, not(overuse)], 0.001).
p(car, [not(carr_acc), not(fall), not(overuse)], 0.001).
% Was overuse the cause?
p(over, [overuse, fall, car_acc], 0.33).
p(over, [overuse, not(fall), car_acc], 0.50).
p(over, [overuse, fall, not(car_acc)], 0.50).
p(over, [overuse, not(fall), not(car_acc)], 0.99).
p(over, [not(overuse), fall, car_acc], 0.001).
p(over, [not(overuse), not(fall), car_acc], 0.001).
p(over, [not(overuse), fall, not(car_acc)], 0001).
p(over, [not(overuse), not(fall), not(car_acc)], 0.001).
% Was a fall the cause?
p(fallen, [fall, overuse, car_acc], 0.33).
p(fallen, [fall, not(overuse), car_acc], 0.50).
p(fallen, [fall, overuse, not(car_acc)], 0.50).
p(fallen, [fall, not(overuse), not(car_acc)], 0.99).
p(fallen, [not(fall), overuse, car_acc], 0.001).
p(fallen, [not(fall), not(overuse), car_acc], 0.001).
p(fallen, [not(fall), overuse, not(car_acc)], 0.001).
p(fallen, [not(fall), not(overuse), not(overuse)], 0.001).

% For torn muscle
% Was putting the muscle in a vulnerable position the cause?
p(vuln, [vuln_pos, fall, weights], 0.33).
p(vuln, [vuln_pos, not(fall), weights], 0.50).
p(vuln, [vuln_pos, fall, not(weights)], 0.50).
p(vuln, [vuln_pos, not(fall), not(weights)], 0.99).
p(vuln, [not(vuln_pos), fall, weights], 0.001).
p(vuln, [not(vuln_pos), not(fall), weights], 0.001).
p(vuln, [not(vuln_pos), fall, not(weights)], 0.001).
p(vuln, [not(vuln_pos), not(fall), not(weights)], 0.001).
% Was lifting weights the cause?
p(weigh, [weights, fall, vuln_pos], 0.33).
p(weigh, [weights, not(fall), vuln_pos], 0.50).
p(weigh, [weights, fall, not(vuln_pos)], 0.50).
p(weigh, [weights, not(fall), not(vuln_pos)], 0.99).
p(weigh, [not(weights), fall, vuln_pos], 0.001).
p(weigh, [not(weights), not(fall), vuln_pos], 0.001).
p(weigh, [not(weights), fall, not(vuln_pos)], 0.001).
p(weigh, [not(weights), not(fall), not(vuln_pos)], 0.001).
% Was a fall the cause?
p(fallen, [fall, weights, vuln_pos], 0.33).
p(fallen, [fall, not(weights), vuln_pos], 0.50).
p(fallen, [fall, weights, not(vuln_pos)], 0.50).
p(fallen, [fall, not(weights), not(vuln_pos)], 0.99).
p(fallen, [not(fall), weights, vuln_pos], 0.001).
p(fallen, [not(fall), not(weights), vuln_pos], 0.001).
p(fallen, [not(fall), weights, not(vuln_pos)], 0.001).
p(fallen, [not(fall), not(weights), not(vuln_pos)], 0.001).


% Step 4:  Define FC rules here as in HW2:

% Rules for injury type.
if pulled_muscle then client_has_pulled_muscle.
if torn_muscle then client_has_torn_muscle.
if broken_bone then client_has_broken_bone.
% Rules for Pulled muscle symptoms.
if low_range_of_motion then client_has_low_range_of_motion.
if normal_range_of_motion then client_has_normal_range_of_motion.
if has_pain then client_experiencing_pain.
if no_pain then client_experiencing_no_pain.
if is_stiff then client_is_stiff_in_injured_area.
if not_stiff then client_is_not_stiff_in_injured_area.
% Rules for pulled muscle causes.
if proper_warmup then client_had_proper_warmup.
if improper_warmup then client_had_improper_warmup.
if is_flexible then client_is_flexible_in_injured_area.
if not_flexible then client_is_not_flexible_in_injured_area.
if was_fatigued then cliet_was_fatigued.
if was_not_fatigued then client_was_not_fatigued.
% Rules for torn muscle symptoms.
if color then client_experiencing_discoloring.
if no_color then client_has_no_discoloring.
if spasm then client_experiencing_muscle_spasms.
if no_spasm then client_not_experiencing_muscle_spasms.
% Rules for torn muscle causes.
if lifting_weights then client_was_lifting_weights.
if not_lifting_weights then client_was_not_lifting_weights.
if in_vuln_pos then client_was_in_vulnerable_position.
if not_in_vuln_pos then client_was_not_in_vulnerable_position.
if client_fell then client_fell.
if not_fall then client_did_not_fall.
% Broken Bone symptoms.
if deformity then client_shows_deformity.
if no_deformity then client_not_showing_deformity.
if swelling then client_is_swelled_up.
if no_swelling then client_is_not_swelled_up.
if bruising then client_is_bruised.
if no_bruising then client_is_not_bruised.
% Broken Bone causes.
if car_acc then client_had_car_accident.
if no_car_acc then client_did_not_have_car_accident.
if overuse then overuse_detected_from_client.
if no_overuse then no_overuse_detected_from_client.
% Solutions for healing.
if rest then client_needs_to_rest_body.
if ice then client_needs_to_ice_muscle.
if compress then client_needs_to_compress_muscle.
if elevate then client_needs_to_elevate_muscle.
if visit_doctor then client_needs_to_visit_doctor_regularly.



% Step 5:  Implement your main program here
% Starting predicate for program.
go :-
    nl, write('What is hurting you a pulled muscle, torn muscle, or broken bone?'), nl,
    write('Enter pm, tm, or bb: '), read(Injury), assert_injury(Injury), nl, forward, nl, router(Injury), nl.

% Assert the type of injury.
assert_injury(pm) :-
    assert(fact(pulled_muscle)).
assert_injury(tm) :-
    assert(fact(torn_muscle)).
assert_injury(bb) :-
    assert(fact(broken_bone)).

% Predicates that route the user to certain prompts depending on their
% injury type.
router(pm) :-
    pulled_muscle.
router(tm) :-
    torn_muscle.
router(bb) :-
    broken_bone.

% Start of the pulled muscle questions.
pulled_muscle :-
    write('Since you say you have a pulled muscle let me see if you are showing common symptoms of a muscle pull.'), nl,
    write('Are you experiencing limited range of motion (enter y or n)?: '),
    read(Range), trans_ROM(Range, LROM), assert_symptom(LROM), nl,
    write('Did you feel sudden pain when the injury occured (y or n)?: '),
    read(P), trans_pain(P, Pain), assert_symptom(Pain), nl,
    write('Do you feel tightness or stiffness in the injured area (y or n)?: '),
    read(Stiff), trans_stiff(Stiff, Stiffness), assert_symptom(Stiffness), nl, nl, forward, nl,
    test_pulled_muscle_symptoms(LROM, Pain, Stiffness).

% Assert symptom facts.
assert_symptom(lrom) :-
    assert(fact(low_range_of_motion)).
assert_symptom(not(lrom)) :-
    assert(fact(normal_range_of_motion)).
assert_symptom(pain) :-
    assert(fact(has_pain)).
assert_symptom(not(pain)) :-
    assert(fact(no_pain)).
assert_symptom(stiff) :-
    assert(fact(is_stiff)).
assert_symptom(not(stiff)) :-
    assert(fact(not_stiff)).

% Translator predicates for user responses.
trans_ROM(y, lrom).
trans_ROM(n, not(lrom)).

trans_pain(y, pain).
trans_pain(n, not(pain)).

trans_stiff(y, stiff).
trans_stiff(n, not(stiff)).

% Predicates to see if user is experiencing common symptoms of a
% pulled muscle. If two or more symptoms match with a pulled muscle then
% that is classified as a pulled muscle. If only 1 symptom matches it
% does not. If not then they may not have a pulled muscle. Then send the
% user to a predicate to diagnose a possible cause of their injury.
test_pulled_muscle_symptoms(lrom, pain, stiff) :-
    pulled_muscle_causes.
test_pulled_muscle_symptoms(not(lrom), pain, stiff) :-
    pulled_muscle_causes.
test_pulled_muscle_symptoms(lrom, not(pain), stiff) :-
    pulled_muscle_causes.
test_pulled_muscle_symptoms(lrom, pain, not(stiff)) :-
    pulled_muscle_causes.
test_pulled_muscle_symptoms(not(lrom), not(pain), stiff) :-
    failed_pulled_muscle.
test_pulled_muscle_symptoms(not(lrom), pain, not(stiff)) :-
    failed_pulled_muscle.
test_pulled_muscle_symptoms(lrom, not(pain), not(stiff)) :-
    failed_pulled_muscle.
test_pulled_muscle_symptoms(not(lrom), not(pain), not(stiff)) :-
    failed_pulled_muscle.

% Failed predicate for if user didnt show common symptoms of a pulled
% muscle.
failed_pulled_muscle :-
    write('Based on your symptoms im not sure if you have a pulled muscle. Lets restart.'), nl, go.

% Predicate to get user input from possible causes of their injury.
pulled_muscle_causes :-
    write('You are showing symptoms of a pulled muscle. Lets try to figure out how this may have happened.'), nl,
    write('Did you do any kind of warmup before you hurt yourself (y or n)?: '),
    read(Warm), trans_warmup(Warm, Warmup), assert_cause(Warmup), nl,
    write('Is that muscle flexible (y or n)?: '),
    read(Flex), trans_flexible(Flex, Flexible), assert_cause(Flexible), nl,
    write('Was your body fatigued when you got injured (y or n)?: '),
    read(Tired), trans_fatigue(Tired, Fatigue), assert_cause(Fatigue), nl, forward, nl,
    diagnose_pulled_muscle_cause(Warmup, Flexible, Fatigue).

% Assert causes.
assert_cause(warmup) :-
    assert(fact(proper_warmup)).
assert_cause(not(warmup)) :-
    assert(fact(improper_warmup)).
assert_cause(flexibility) :-
    assert(fact(is_flexible)).
assert_cause(not(flexibility)) :-
    assert(fact(not_flexible)).
assert_cause(fatigue) :-
    assert(fact(was_fatigued)).
assert_cause(not(fatigued)) :-
    assert(fact(was_not_fatigued)).

% Translator predicates for user responses.
trans_warmup(y, warmup).
trans_warmup(n, not(warmup)).

trans_flexible(y, flexibility).
trans_flexible(n, not(flexibility)).

trans_fatigue(y, fatigue).
trans_fatigue(n, not(fatigue)).


% Predicate to diagnose the cause of the pulled muscle.
diagnose_pulled_muscle_cause(Warmup, Flexible, Fatigue) :-
    prob(warm, [Warmup, Flexible, Fatigue], PW),
    prob(flex, [Flexible, Warmup, Fatigue], PF),
    prob(fat, [Fatigue, Warmup, Flexible], PFAT),
    present_pulled_muscle_cause(PW, PF, PFAT), nl,
    solution_for_torn_pulled_muscle, forward, nl,
    is_that_all.

% Predicates that display different messages to the user based on the
% probability outcomes from the BN.
present_pulled_muscle_cause(PW, PF, PFAT) :-
    PW > PF, PW > PFAT,
    write('The most likely cause of your injury was a improper warmup at '), write(PW), write('%').
present_pulled_muscle_cause(PW, PF, PFAT) :-
    PF > PW, PF > PFAT,
    write('The most likely cause of your injury was poor flexibility at '), write(PF), write('%').
present_pulled_muscle_cause(PW, PF, PFAT) :-
    PFAT > PW, PFAT > PF,
    write('The most likely cause of your injury was body fatigue at '), write(PFAT), write('%').
present_pulled_muscle_cause(PW, PF, PFAT) :-
    PW = PF, PW > PFAT,
    write('There is a equally likely chance that an improper warmup and poor flexibility was the cause of your injury at '),
    write(PW), write('%').
% Predicates to protect against equal outcomes from BN.
present_pulled_muscle_cause(PW, PF, PFAT) :-
    PW = PFAT, PW > PF,
    write('There is a equally likely chance that an improper warmup and body fatigue was the cause of your injury at '),
    write(PW), write('%').
present_pulled_muscle_cause(PW, PF, PFAT) :-
    PF = PFAT, PF > PW,
    write('There is an equally likely chance that poor flexibility and body fatigue was the cause of your injury at '), write(PF), write('%').




% Start of the torn muscle questions.
torn_muscle :-
    write('Since you think you have a torn muscle lets see if you have the common symptoms of a torn muscle.'), nl,
    write('Are you experiencing bruising or color changes in the injured area (y or n)?: '),
    read(Bruise), trans_bruise(Bruise, Color), assert_symptom(Color), nl,
    write('Are you experiencing muscle spasms in the injured area (y or n)?: '),
    read(MS), trans_spasm(MS, Spasm), assert_symptom(Spasm), nl,
    write('Did you feel sudden pain in the injured area at time of injury (y or n)?: '),
    read(SP), trans_sudden(SP, Pain), assert_symptom(Pain), nl, nl, forward, nl,
    test_torn_muscle_symptoms(Color, Spasm, Pain).

% Assert new symptom types.
assert_symptom(color) :-
    assert(fact(color)).
assert_symptom(not(color)) :-
    assert(fact(no_color)).
assert_symptom(spasm) :-
    assert(fact(spasm)).
assert_symptom(not(spasm)) :-
    assert(fact(no_spasm)).

% Translator predicates for torn muscle symptoms.
trans_bruise(y, color).
trans_bruise(n, not(color)).

trans_spasm(y, spasm).
trans_spasm(n, not(spasm)).

trans_sudden(y, pain).
trans_sudden(n, not(pain)).

% Predicate to test if symptoms match a torn muscle. At least 2 symptoms
% must match. If they do they are sent to diagnose the casue of injury.
% If not, the user may not have a torn muscle so they are sent back to
% the start menu.
test_torn_muscle_symptoms(color, spasm, pain) :-
    torn_muscle_causes.
test_torn_muscle_symptoms(not(color), spasm, pain) :-
    torn_muscle_causes.
test_torn_muscle_symptoms(color, not(spasm), pain) :-
    torn_muscle_causes.
test_torn_muscle_symptoms(color, spasm, not(pain)) :-
    torn_muscle_causes.
test_torn_muscle_symptoms(not(color), not(spasm), pain) :-
    failed_torn_muscle.
test_torn_muscle_symptoms(not(color), spasm, not(pain)) :-
    failed_torn_muscle.
test_torn_muscle_symptoms(color, not(spasm), not(pain)) :-
    failed_torn_muscle.
test_torn_muscle_symptoms(not(color), not(spasm), not(pain)) :-
    failed_torn_muscle.

% Predicate for if the user didnt display common symptoms of a torn
% muscle.
failed_torn_muscle :-
    write('Based on your symptoms im not sure you have a torn muscle. Lets restart.'), nl, go.

% Predicate to try and diagnose the cause of the torn muscle.
torn_muscle_causes :-
    write('You are showing symptoms of a torn muscle. Lets try to find out what caused it.'), nl,
    write('Were you lifting heavy weights (y or n)?: '),
    read(Lifting), trans_lifting(Lifting, Weights), assert_cause(Weights), nl,
    write('Were you putting your muscle in vulnerable positions (y or n)?: '),
    read(Vuln), trans_vuln(Vuln, Vulnerable), assert_cause(Vulnerable), nl,
    write('Did you happen to fall wrong on that particular muscle (y or n)?: '),
    read(F), trans_fall(F, Fall), assert_cause(Fall), nl, nl, forward, nl,
    diagnose_torn_muscle_cause(Weights, Vulnerable, Fall).

% Assert causes of torn muscle.
assert_cause(weights) :-
    assert(fact(lifting_weights)).
assert_cause(not(weights)) :-
    assert(fact(not_lifting_weights)).
assert_cause(vuln_pos) :-
    assert(fact(in_vuln_pos)).
assert_cause(not(vuln_pos)) :-
    assert(fact(not_in_vuln_pos)).
assert_cause(fall) :-
    assert(fact(client_fell)).
assert_cause(not(fall)) :-
    assert(fact(not_fall)).

% Translator predicates for user responses.
trans_lifting(y, weights).
trans_lifting(n, not(weights)).

trans_vuln(y, vuln_pos).
trans_vuln(n, not(vuln_pos)).

trans_fall(y, fall).
trans_fall(n, not(fall)).

% Predicate for diagnosing the cause for the torn muscle.
diagnose_torn_muscle_cause(Weights, Vulnerable, Fall) :-
    prob(weigh, [Weights, Fall, Vulnerable], PW),
    prob(vuln, [Vulnerable, Fall, Weights], PV),
    prob(fal, [Fall, Weights, Vulnerable], PF),
    present_torn_muscle_cause(PW, PV, PF),nl,
    solution_for_torn_pulled_muscle, forward, nl,
    is_that_all.

% Predicate that gives information about healing torn muscle.
solution_for_torn_pulled_muscle :-
    write('Below are some ways you can fix your a torn or pulled muscle: '),
    assert(fact(rest)),
    assert(fact(ice)),
    assert(fact(compress)),
    assert(fact(elevate)), nl.

% Predicates for presenting the user with the most likely cause for
% their injury.
present_torn_muscle_cause(PW, PV, PF) :-
    PW > PV, PV >= PF,
    write('The most likely cause for your injury is lifting weights at '), write(PW), write('%').
present_torn_muscle_cause(PW, PV, PF) :-
    PF > PW, PW >= PV,
    write('The most likely cause of your injury is a fall at '), write(PF), write('%').
present_torn_muscle_cause(PW, PV, PF) :-
    PV > PW, PW >= PF,
    write('The most likely cause of your injury was putting your muscle in a vulnerable position at '), write(PV), write('%').
% Guard against equally likely outcomes from BN.
present_torn_muscle_cause(PW, PV, PF) :-
    PW = PV, PV > PF,
    write('The is an equally likely chance that lifting weights and putting your muscle in a vulnerable position caused your injury at '),
    write(PW), write('%').
present_torn_muscle_cause(PW, PV, PF) :-
    PW = PF, PF > PV,
    write('There is an equally likely chance that lifting weights and falling caused your injury at '), write(PW), write('%').
present_torn_muscle_cause(PW, PV, PF) :-
    PF = PV, PV > PW,
    write('There is an equally likely chance that a fall and putting your muscle in a vulnerable position caused your injury at '),
    write(PF), write('%').



% Start of Broken Bone questions.
broken_bone :-
    write('Since you think you have broken a bone. Let me see if you have some common symptoms of a broken bone.'), nl,
    write('Is there a deformity in the area of the broken bone (y or n)?: '),
    read(Deform), trans_deformity(Deform, Deformity), assert_symptom(Deformity), nl,
    write('Is there swelling in the area (y or n)?: '),
    read(Sw), trans_swelling(Sw, Swelling), assert_symptom(Swelling), nl,
    write('Is there bruising in the area (y or n)?: '),
    read(Br), trans_bruising(Br, Bruising), assert_symptom(Bruising), nl, nl, forward, nl,
    test_broken_bone_symptoms(Deformity, Swelling, Bruising).

% Broken bone symptoms.
assert_symptom(deformity) :-
    assert(fact(deformity)).
assert_symptom(not(deformity)) :-
    assert(fact(no_deformity)).
assert_symptom(swelling) :-
    assert(fact(swelling)).
assert_symptom(not(swelling)) :-
    assert(fact(no_swelling)).
assert_symptom(bruising) :-
    assert(fact(bruising)).
assert_symptom(not(bruising)) :-
    assert(fact(no_bruising)).

% Translator classes for user input.
trans_deformity(y, deformity).
trans_deformity(n, not(deformity)).

trans_swelling(y, swelling).
trans_swelling(n, not(swelling)).

trans_bruising(y, bruising).
trans_bruising(n, not(bruising)).

% Predicates to test and see if user has symptoms of broken bone. Must
% have at least 2 matching symptoms to move on.
test_broken_bone_symptoms(deformity, swelling, bruising) :-
    broken_bone_causes.
test_broken_bone_symptoms(not(deformity), swelling, bruising) :-
    broken_bone_causes.
test_broken_bone_symptoms(deformity, not(swelling), bruising) :-
    broken_bone_causes.
test_broken_bone_symptoms(deformity, swelling, not(bruising)) :-
    broken_bone_causes.
test_broken_bone_symptoms(not(deformity), not(swelling), bruising) :-
    failed_broken_bone.
test_broken_bone_symptoms(not(deformity), swelling, not(bruising)) :-
    failed_broken_bone.
test_broken_bone_symptoms(deformity, not(swelling), not(bruising)) :-
    failed_broken_bone.
test_broken_bone_symptoms(not(deformity), not(swelling), not(bruising)) :-
    failed_broken_bone.

% Predicate for if the user failed the broken bone symptoms test.
failed_broken_bone :-
    write('Based on your symptoms im not sure if you have a broken bone. Lets restart.'), nl, go.

broken_bone_causes :-
    write('You are showing symptoms of a broken bone. Lets try to figure out how this may have happened.'), nl,
    write('Did you fall causing you to break the bone (y or n)?: '),
    read(Fal), trans_fal(Fal, Fall), assert_cause(Fall), nl,
    write('Were you involved in a car accident (y or n)?: '),
    read(Car), trans_car(Car, Car_acc), assert_cause(Car_acc), nl,
    write('Is there any way you may have overused that part of your body leading to partial '),
    nl, write('fractures in the area that casued a slight break in the area (y or n)?: '),
    read(Over), trans_overuse(Over, Overuse), assert_cause(Overuse), nl, nl, forward, nl,
    diagnose_broken_bone_cause(Fall, Car_acc, Overuse).

% Assert causes of broken bone.
assert_cause(car_acc) :-
    assert(fact(car_acc)).
assert_cause(not(car_acc)) :-
    assert(fact(no_car_acc)).
assert_cause(overuse) :-
    assert(fact(overuse)).
assert_cause(not(overuse)) :-
    assert(fact(no_overuse)).

% Translator predicates for user input.
trans_fal(y, fall).
trans_fal(n, not(fall)).

trans_car(y, car_acc).
trans_car(n, not(car_acc)).

trans_overuse(y, overuse).
trans_overuse(n, not(overuse)).

% Predicate to diagnose the most probable cause of the bone break.
diagnose_broken_bone_cause(Fall, Car_acc, Overuse) :-
    prob(car, [Car_acc, Fall, Overuse], PC),
    prob(over, [Overuse, Fall, Car_acc], PO),
    prob(fallen, [Fall, Overuse, Car_acc], PF),
    present_broken_bone_cause(PC, PO, PF), nl,
    solution_for_broken_bone, forward, nl,
    is_that_all.

% Predicates that display to user the most likely cause of their injury.
present_broken_bone_cause(PC, PO, PF) :-
    PC > PO, PO >= PF,
    write('The most likely cause of your injury is from your car accident at '), write(PC), write('%').
present_broken_bone_cause(PC, PO, PF) :-
    PO > PC, PC >= PF,
    write('The most likely cause of your injury is from overuse at '), write(PO), write('%').
present_broken_bone_cause(PC, PO, PF) :-
    PF > PC, PC >= PO,
    write('The most likely cause of your injury is from your fall at '), write(PF), write('%').
present_broken_bone_cause(PC, PO, PF) :-
    PC = PO, PC > PF,
    write('There is an equally likely chance that your car crash and overuse caused your injury at '), write(PC), write('%').
present_broken_bone_cause(PC, PO, PF) :-
    PC = PF, PC > PO,
    write('There is an equally likely chance that your car crash and your fall caused your injury at '), write(PC), write('%').
present_broken_bone_cause(PC, PO, PF) :-
    PF = PO, PF > PC,
    write('There is an equally likely chance that your fall and overuse caused your injury at '), write(PF), write('%').

% Print to user solutions to healing broken bone.
solution_for_broken_bone :-
    write('Below are some ways you can heal your broken bone: '),nl,
    assert(fact(cast)),nl,
    assert(fact(rest)),nl,
    assert(fact(visit_doctor)), nl.

% Predicate to allow for user to enter another injury if they have it.
is_that_all :-
    nl, write('Are there any other injuries you have at the moment (y or n)?: '), read(Additional), trans_add_injury(Additional).

% Translator predicte that acts on whether or not user has additional
% injuries.
trans_add_injury(y):-
    go.
trans_add_injury(n) :-
    write('Make sure to follow the advice above and have a great day.').
