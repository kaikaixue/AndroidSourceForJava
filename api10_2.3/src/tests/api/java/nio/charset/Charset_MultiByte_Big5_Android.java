/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tests.api.java.nio.charset;

import dalvik.annotation.AndroidOnly;
import dalvik.annotation.TestTargetClass;

@AndroidOnly("icu different from RI")

public class Charset_MultiByte_Big5_Android extends Charset_AbstractTest {

    @Override
    protected void setUp() throws Exception {
        charsetName = "Big5";

        testChars = theseChars(new int[]{
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95,
96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127,
128, 167, 175, 176, 177, 183, 215, 247, 711, 713, 913, 933, 953, 8211, 8231, 8251,
8364, 8451, 8544, 8592, 8725, 8745, 8786, 8806, 8853, 8895, 9472, 9492, 9516, 9552, 9572, 9601,
9621, 9650, 9670, 9698, 9733, 9792, 12288, 12308, 12328, 12549, 12569, 12963, 13198, 13252, 19968, 19988,
20011, 20034, 20054, 20083, 20104, 20126, 20147, 20167, 20188, 20208, 20228, 20248, 20268, 20289, 20309, 20329,
20349, 20369, 20398, 20418, 20438, 20460, 20480, 20500, 20520, 20540, 20561, 20581, 20602, 20622, 20642, 20662,
20682, 20704, 20725, 20745, 20767, 20787, 20807, 20827, 20849, 20871, 20894, 20918, 20938, 20958, 20979, 20999,
21020, 21040, 21060, 21082, 21102, 21122, 21142, 21162, 21182, 21202, 21222, 21242, 21262, 21282, 21303, 21324,
21344, 21365, 21386, 21406, 21426, 21448, 21471, 21491, 21511, 21531, 21552, 21573, 21600, 21620, 21640, 21664,
21686, 21710, 21730, 21751, 21771, 21798, 21819, 21839, 21859, 21879, 21899, 21919, 21939, 21959, 21979, 21999,
22020, 22043, 22063, 22085, 22105, 22125, 22145, 22165, 22186, 22206, 22227, 22247, 22271, 22291, 22312, 22334,
22354, 22374, 22395, 22415, 22435, 22456, 22476, 22496, 22516, 22536, 22556, 22576, 22600, 22621, 22641, 22661,
22684, 22705, 22725, 22745, 22767, 22787, 22807, 22827, 22848, 22868, 22889, 22909, 22930, 22950, 22970, 22990,
23011, 23031, 23052, 23072, 23093, 23113, 23133, 23159, 23179, 23199, 23219, 23239, 23259, 23283, 23303, 23323,
23343, 23363, 23383, 23403, 23423, 23443, 23463, 23487, 23507, 23527, 23553, 23573, 23594, 23614, 23636, 23656,
23676, 23696, 23716, 23736, 23756, 23784, 23805, 23825, 23845, 23865, 23886, 23906, 23927, 23949, 23969, 23989,
24009, 24029, 24049, 24070, 24090, 24115, 24138, 24159, 24179, 24199, 24219, 24240, 24260, 24280, 24300, 24321,
24341, 24361, 24384, 24404, 24425, 24445, 24465, 24485, 24505, 24525, 24545, 24565, 24585, 24605, 24626, 24646,
24666, 24686, 24707, 24727, 24752, 24772, 24792, 24816, 24836, 24856, 24876, 24896, 24916, 24936, 24956, 24976,
24996, 25016, 25036, 25056, 25077, 25097, 25119, 25139, 25159, 25179, 25199, 25219, 25239, 25259, 25279, 25299,
25323, 25343, 25363, 25384, 25404, 25424, 25445, 25466, 25486, 25506, 25533, 25554, 25575, 25606, 25626, 25646,
25667, 25688, 25708, 25730, 25750, 25771, 25791, 25812, 25832, 25852, 25872, 25892, 25912, 25935, 25955, 25975,
25996, 26016, 26038, 26059, 26079, 26099, 26119, 26140, 26161, 26181, 26201, 26222, 26244, 26264, 26286, 26308,
26328, 26348, 26368, 26388, 26408, 26428, 26448, 26474, 26494, 26514, 26542, 26562, 26584, 26604, 26642, 26662,
26682, 26702, 26731, 26751, 26771, 26791, 26820, 26840, 26860, 26884, 26917, 26937, 26958, 26978, 26998, 27021,
27041, 27061, 27081, 27106, 27126, 27146, 27166, 27186, 27206, 27226, 27247, 27267, 27287, 27308, 27330, 27353,
27374, 27394, 27414, 27436, 27457, 27477, 27498, 27518, 27540, 27562, 27583, 27603, 27623, 27643, 27663, 27683,
27704, 27724, 27744, 27764, 27784, 27804, 27824, 27844, 27865, 27885, 27905, 27926, 27946, 27966, 27992, 28012,
28032, 28052, 28074, 28094, 28114, 28134, 28154, 28185, 28205, 28225, 28245, 28265, 28296, 28316, 28336, 28356,
28376, 28396, 28416, 28436, 28457, 28478, 28498, 28518, 28538, 28558, 28578, 28598, 28618, 28638, 28658, 28678,
28698, 28719, 28739, 28759, 28779, 28802, 28822, 28843, 28869, 28889, 28911, 28932, 28953, 28974, 28994, 29014,
29034, 29056, 29076, 29096, 29116, 29136, 29156, 29176, 29196, 29218, 29238, 29258, 29278, 29298, 29318, 29338,
29358, 29378, 29398, 29418, 29438, 29458, 29478, 29498, 29518, 29538, 29558, 29578, 29599, 29619, 29639, 29659,
29684, 29704, 29725, 29745, 29766, 29786, 29806, 29827, 29847, 29867, 29887, 29908, 29928, 29949, 29969, 29989,
30009, 30030, 30050, 30070, 30090, 30114, 30134, 30154, 30174, 30194, 30216, 30236, 30256, 30278, 30298, 30318,
30338, 30358, 30378, 30398, 30418, 30438, 30458, 30480, 30501, 30521, 30541, 30561, 30585, 30605, 30625, 30645,
30665, 30686, 30706, 30726, 30749, 30769, 30789, 30812, 30832, 30852, 30872, 30892, 30913, 30933, 30953, 30973,
30993, 31013, 31033, 31055, 31075, 31097, 31117, 31137, 31158, 31179, 31199, 31222, 31242, 31262, 31287, 31307,
31327, 31348, 31368, 31390, 31410, 31431, 31455, 31478, 31498, 31518, 31538, 31558, 31584, 31604, 31624, 31644,
31665, 31686, 31706, 31728, 31749, 31769, 31789, 31811, 31831, 31851, 31871, 31892, 31912, 31932, 31952, 31975,
31995, 32015, 32040, 32060, 32080, 32102, 32122, 32142, 32162, 32183, 32203, 32223, 32243, 32264, 32284, 32304,
32324, 32344, 32365, 32385, 32405, 32566, 32586, 32606, 32626, 32646, 32666, 32687, 32707, 32727, 32747, 32767,
32788, 32808, 32829, 32849, 32871, 32893, 32914, 32937, 32962, 32982, 33005, 33025, 33045, 33065, 33085, 33105,
33125, 33145, 33165, 33186, 33207, 33228, 33248, 33268, 33288, 33308, 33330, 33351, 33371, 33391, 33411, 33432,
33452, 33472, 33492, 33512, 33534, 33558, 33578, 33599, 33619, 33651, 33671, 33691, 33711, 33731, 33751, 33771,
33791, 33811, 33833, 33853, 33873, 33893, 33913, 33933, 33953, 33974, 33994, 34023, 34043, 34063, 34083, 34107,
34129, 34149, 34169, 34189, 34209, 34229, 34249, 34269, 34289, 34309, 34329, 34349, 34371, 34393, 34413, 34437,
34457, 34479, 34499, 34519, 34539, 34560, 34584, 34604, 34624, 34644, 34664, 34689, 34710, 34730, 34750, 34770,
34790, 34810, 34832, 34852, 34872, 34892, 34913, 34933, 34953, 34974, 34994, 35017, 35037, 35057, 35077, 35097,
35117, 35137, 35158, 35178, 35198, 35219, 35242, 35262, 35282, 35302, 35322, 35342, 35362, 35382, 35402, 35422,
35442, 35462, 35482, 35504, 35524, 35544, 35565, 35585, 35605, 35626, 35646, 35666, 35686, 35706, 35726, 35895,
35915, 35935, 35955, 35977, 35997, 36018, 36039, 36060, 36080, 36100, 36121, 36196, 36216, 36236, 36256, 36276,
36296, 36316, 36336, 36356, 36376, 36398, 36418, 36438, 36458, 36481, 36501, 36521, 36541, 36561, 36581, 36601,
36621, 36643, 36663, 36683, 36703, 36763, 36783, 36804, 36832, 36852, 36875, 36895, 36916, 36937, 36957, 36978,
36998, 37019, 37039, 37059, 37079, 37099, 37119, 37140, 37160, 37182, 37202, 37224, 37248, 37273, 37293, 37313,
37333, 37353, 37373, 37393, 37413, 37433, 37453, 37473, 37494, 37514, 37536, 37556, 37576, 37597, 37617, 37638,
37658, 37678, 37702, 37722, 37744, 37768, 37789, 37809, 37831, 37852, 37877, 37897, 37920, 37941, 37961, 37981,
38001, 38263, 38283, 38303, 38325, 38345, 38366, 38428, 38448, 38468, 38488, 38508, 38528, 38548, 38568, 38588,
38610, 38632, 38653, 38673, 38693, 38713, 38738, 38758, 38778, 38798, 38818, 38838, 38859, 38879, 38899, 38919,
38939, 38959, 38979, 38999, 39019, 39080, 39100, 39131, 39151, 39171, 39191, 39211, 39231, 39251, 39318, 39339,
39361, 39381, 39401, 39421, 39441, 39461, 39481, 39501, 39522, 39592, 39612, 39632, 39654, 39674, 39694, 39714,
39735, 39755, 39775, 39796, 39816, 39838, 39861, 39881, 39902, 39927, 39947, 39969, 39990, 40010, 40030, 40051,
40165, 40185, 40208, 40229, 40251, 40271, 40295, 40315, 40336, 40356, 40376, 40396, 40417, 40437, 40457, 40477,
40565, 40585, 40605, 40628, 40648, 40668, 40688, 40710, 40730, 40750, 40770, 40790, 40810, 40830, 40850, 57344,
57364, 57384, 57404, 57424, 57444, 57464, 57484, 57504, 57524, 57544, 57564, 57584, 57604, 57624, 57644, 57664,
57684, 57704, 57724, 57744, 57764, 57784, 57804, 57824, 57844, 57864, 57884, 57904, 57924, 57944, 57964, 57984,
58004, 58024, 58044, 58064, 58084, 58104, 58124, 58144, 58164, 58184, 58204, 58224, 58244, 58264, 58284, 58304,
58324, 58344, 58364, 58384, 58404, 58424, 58444, 58464, 58484, 58504, 58524, 58544, 58564, 58584, 58604, 58624,
58644, 58664, 58684, 58704, 58724, 58744, 58764, 58784, 58804, 58824, 58844, 58864, 58884, 58904, 58924, 58944,
58964, 58984, 59004, 59024, 59044, 59064, 59084, 59104, 59124, 59144, 59164, 59184, 59204, 59224, 59244, 59264,
59284, 59304, 59324, 59344, 59364, 59384, 59404, 59424, 59444, 59464, 59484, 59504, 59524, 59544, 59564, 59584,
59604, 59624, 59644, 59664, 59684, 59704, 59724, 59744, 59764, 59784, 59804, 59824, 59844, 59864, 59884, 59904,
59924, 59944, 59964, 59984, 60004, 60024, 60044, 60064, 60084, 60104, 60124, 60144, 60164, 60184, 60204, 60224,
60244, 60264, 60284, 60304, 60324, 60344, 60364, 60384, 60404, 60424, 60444, 60464, 60484, 60504, 60524, 60544,
60564, 60584, 60604, 60624, 60644, 60664, 60684, 60704, 60724, 60744, 60764, 60784, 60804, 60824, 60844, 60864,
60884, 60904, 60924, 60944, 60964, 60984, 61004, 61024, 61044, 61064, 61084, 61104, 61124, 61144, 61164, 61184,
61204, 61224, 61244, 61264, 61284, 61304, 61324, 61344, 61364, 61384, 61404, 61424, 61444, 61464, 61484, 61504,
61524, 61544, 61564, 61584, 61604, 61624, 61644, 61664, 61684, 61704, 61724, 61744, 61764, 61784, 61804, 61824,
61844, 61864, 61884, 61904, 61924, 61944, 61964, 61984, 62004, 62024, 62044, 62064, 62084, 62104, 62124, 62144,
62164, 62184, 62204, 62224, 62244, 62264, 62284, 62304, 62324, 62344, 62364, 62384, 62404, 62424, 62444, 62464,
62484, 62504, 62524, 62544, 62564, 62584, 62604, 62624, 62644, 62664, 62684, 62704, 62724, 62744, 62764, 62784,
62804, 62824, 62844, 62864, 62884, 62904, 62924, 62944, 62964, 62984, 63004, 63024, 63044, 63064, 63084, 63104,
63124, 63144, 63164, 63184, 63204, 63224, 63244, 63264, 63284, 63304, 63324, 63344, 63364, 63384, 63404, 63424,
63444, 63464, 63484, 63504, 63524, 63544, 63736, 64012, 65072, 65092, 65113, 65281, 65301, 65321, 65343, 65363,
65504
            });

        testBytes = theseBytes(new int[]{
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31,
32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63,
64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95,
96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111,
112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127,
128, 161, 177, 161, 194, 162, 88, 161, 211, 161, 80, 161, 209, 161, 210, 163,
190, 163, 188, 163, 68, 163, 87, 163, 100, 161, 86, 161, 69, 161, 176, 163,
225, 162, 74, 162, 185, 161, 246, 162, 65, 161, 228, 161, 220, 161, 216, 161,
242, 161, 233, 162, 119, 162, 124, 162, 115, 249, 249, 249, 231, 162, 98, 162,
121, 161, 182, 161, 187, 162, 168, 161, 185, 161, 240, 161, 64, 161, 101, 162,
202, 163, 116, 163, 170, 161, 192, 162, 85, 162, 87, 164, 64, 165, 66, 164,
88, 201, 64, 168, 196, 168, 197, 164, 169, 168, 200, 173, 189, 164, 179, 201,
102, 165, 245, 201, 185, 201, 172, 201, 173, 202, 100, 166, 243, 168, 216, 203,
181, 168, 221, 171, 86, 171, 89, 205, 235, 205, 239, 173, 206, 173, 207, 173,
208, 173, 200, 212, 103, 176, 183, 176, 175, 216, 89, 179, 195, 220, 195, 220,
185, 224, 254, 187, 248, 187, 252, 192, 118, 195, 95, 165, 251, 162, 90, 166,
64, 201, 78, 203, 205, 167, 77, 208, 225, 232, 249, 185, 185, 164, 193, 202,
108, 168, 236, 205, 240, 208, 231, 212, 108, 185, 187, 241, 237, 167, 86, 168,
240, 176, 199, 182, 211, 164, 99, 208, 238, 201, 193, 243, 253, 201, 109, 165,
101, 167, 90, 201, 196, 208, 239, 188, 70, 164, 83, 173, 238, 165, 107, 201,
197, 167, 103, 202, 118, 202, 122, 203, 235, 203, 230, 203, 224, 206, 72, 206,
69, 171, 117, 208, 241, 209, 66, 209, 71, 208, 240, 212, 168, 176, 221, 176,
229, 216, 106, 179, 227, 179, 231, 179, 229, 182, 222, 220, 203, 182, 226, 225,
83, 185, 192, 188, 83, 216, 107, 190, 178, 233, 67, 236, 201, 194, 80, 241,
244, 245, 198, 248, 165, 202, 168, 171, 170, 182, 234, 166, 98, 167, 163, 202,
175, 169, 90, 203, 251, 206, 90, 171, 174, 209, 82, 209, 74, 176, 240, 212,
178, 212, 182, 216, 169, 179, 247, 216, 167, 220, 235, 220, 241, 185, 214, 188,
89, 229, 76, 190, 195, 194, 82, 167, 167, 201, 90, 201, 112, 164, 210, 202,
177, 169, 98, 185, 221, 166, 110, 167, 170, 202, 178, 204, 69, 204, 71, 171,
187, 206, 110, 174, 91, 174, 87, 212, 212, 176, 251, 212, 222, 180, 64, 216,
199, 216, 183, 183, 64, 220, 243, 225, 118, 225, 115, 229, 94, 233, 83, 236,
213, 196, 93, 166, 114, 174, 93, 197, 112, 204, 87, 209, 102, 177, 74, 180,
74, 185, 231, 171, 202, 201, 212, 202, 191, 167, 192, 209, 107, 192, 171, 201,
214, 167, 193, 204, 92, 169, 164, 206, 123, 174, 111, 174, 108, 177, 88, 212,
253, 216, 234, 216, 225, 221, 86, 225, 169, 225, 175, 229, 107, 233, 98, 196,
96, 164, 116, 164, 118, 166, 124, 169, 170, 177, 98, 221, 90, 188, 109, 165,
173, 167, 200, 206, 184, 206, 181, 180, 92, 225, 181, 195, 102, 165, 175, 164,
222, 169, 184, 221, 98, 204, 116, 177, 109, 204, 119, 174, 124, 216, 246, 185,
253, 167, 212, 202, 221, 169, 192, 204, 175, 171, 228, 204, 125, 171, 237, 209,
125, 206, 209, 209, 168, 209, 171, 213, 85, 216, 253, 177, 166, 180, 107, 217,
79, 217, 75, 225, 194, 221, 113, 225, 206, 180, 110, 188, 161, 188, 166, 188,
171, 233, 162, 233, 125, 236, 227, 195, 106, 201, 124, 180, 117, 194, 87, 174,
176, 166, 170, 167, 232, 202, 231, 167, 220, 169, 220, 169, 215, 169, 221, 206,
218, 174, 179, 206, 225, 174, 193, 209, 189, 174, 189, 213, 103, 177, 204, 213,
113, 177, 180, 213, 107, 180, 161, 221, 183, 183, 112, 221, 178, 221, 185, 221,
162, 186, 75, 225, 239, 225, 230, 229, 175, 188, 190, 190, 223, 190, 225, 236,
237, 239, 215, 242, 67, 197, 117, 167, 241, 177, 211, 180, 178, 188, 197, 217,
121, 225, 245, 236, 240, 177, 219, 244, 79, 202, 250, 170, 64, 206, 239, 172,
82, 174, 207, 213, 172, 180, 182, 183, 121, 183, 122, 188, 199, 190, 231, 239,
220, 197, 206, 179, 204, 174, 210, 164, 236, 201, 245, 167, 247, 170, 87, 170,
81, 204, 214, 207, 91, 207, 81, 207, 67, 172, 90, 209, 236, 209, 238, 209,
242, 209, 232, 213, 196, 177, 236, 177, 234, 177, 239, 177, 243, 180, 198, 217,
175, 217, 172, 217, 216, 221, 210, 221, 204, 221, 205, 221, 229, 226, 74, 226,
90, 226, 96, 225, 254, 229, 213, 229, 235, 188, 212, 188, 207, 233, 194, 233,
221, 233, 203, 233, 212, 237, 65, 192, 208, 194, 99, 194, 103, 242, 80, 244,
89, 245, 206, 198, 86, 209, 245, 221, 250, 233, 222, 172, 110, 204, 235, 217,
222, 233, 226, 183, 181, 183, 182, 210, 67, 221, 253, 164, 243, 174, 240, 165,
195, 202, 64, 166, 192, 168, 88, 168, 72, 203, 88, 205, 75, 170, 110, 204,
242, 204, 253, 207, 161, 210, 100, 172, 120, 172, 163, 210, 76, 175, 64, 210,
98, 175, 75, 178, 101, 213, 240, 178, 89, 178, 104, 178, 76, 181, 65, 180,
244, 217, 243, 218, 81, 181, 70, 217, 236, 183, 200, 222, 85, 183, 201, 222,
93, 186, 173, 230, 83, 186, 116, 186, 120, 186, 121, 230, 77, 188, 227, 188,
235, 188, 234, 234, 64, 191, 71, 233, 244, 237, 87, 237, 88, 194, 112, 195,
118, 244, 93, 245, 211, 246, 234, 164, 245, 205, 88, 205, 87, 172, 175, 210,
119, 175, 79, 178, 109, 214, 79, 181, 72, 218, 92, 222, 119, 183, 220, 222,
117, 226, 189, 186, 178, 188, 247, 234, 85, 191, 77, 237, 96, 194, 119, 242,
105, 247, 230, 164, 247, 207, 185, 202, 66, 172, 185, 218, 106, 230, 116, 201,
165, 168, 103, 205, 92, 207, 195, 210, 166, 218, 109, 218, 118, 222, 173, 188,
250, 230, 161, 239, 254, 201, 167, 170, 179, 172, 197, 207, 209, 210, 181, 214,
120, 214, 121, 218, 167, 218, 164, 222, 188, 183, 228, 226, 212, 188, 254, 237,
102, 237, 104, 194, 123, 196, 237, 205, 111, 222, 194, 237, 112, 181, 99, 203,
110, 172, 202, 178, 166, 183, 237, 197, 124, 172, 207, 210, 201, 178, 172, 181,
108, 183, 242, 226, 219, 230, 179, 234, 115, 192, 247, 240, 80, 197, 125, 168,
109, 181, 112, 244, 113, 244, 114, 178, 176, 234, 117, 207, 231, 210, 207, 214,
176, 214, 168, 218, 189, 186, 206, 184, 64, 230, 188, 234, 120, 237, 122, 242,
121, 218, 195, 244, 120, 207, 234, 175, 124, 210, 229, 214, 186, 218, 200, 218,
205, 222, 232, 184, 75, 226, 245, 186, 207, 189, 87, 234, 163, 237, 166, 240,
93, 244, 121, 248, 250, 210, 232, 214, 192, 222, 246, 186, 215, 230, 204, 248,
183, 172, 238, 175, 178, 214, 198, 218, 215, 184, 92, 189, 94, 191, 114, 240,
96, 165, 222, 175, 183, 223, 68, 230, 211, 196, 117, 179, 186, 196, 118, 211,
69, 178, 199, 214, 218, 181, 167, 184, 97, 223, 73, 227, 78, 227, 79, 189,
99, 189, 102, 234, 189, 237, 203, 237, 186, 240, 99, 240, 102, 196, 120, 246,
250, 248, 252, 208, 71, 214, 222, 218, 233, 227, 96, 234, 202, 194, 179, 168,
116, 211, 89, 214, 240, 178, 209, 181, 178, 181, 185, 223, 93, 223, 94, 186,
247, 227, 99, 227, 110, 230, 240, 229, 114, 191, 162, 234, 212, 237, 220, 237,
223, 240, 113, 195, 181, 244, 174, 247, 238, 166, 206, 242, 186, 211, 93, 184,
112, 242, 188, 178, 220, 189, 126, 211, 99, 219, 68, 230, 246, 244, 177, 208,
84, 191, 174, 175, 212, 219, 69, 230, 252, 197, 165, 203, 119, 170, 211, 208,
91, 173, 68, 175, 218, 211, 109, 215, 78, 178, 231, 219, 79, 181, 198, 184,
123, 184, 161, 227, 168, 231, 66, 234, 242, 237, 234, 249, 67, 173, 80, 191,
179, 181, 207, 215, 87, 184, 165, 237, 240, 168, 125, 203, 162, 205, 182, 170,
226, 205, 179, 173, 97, 208, 111, 208, 108, 211, 168, 211, 164, 211, 122, 211,
177, 215, 94, 215, 119, 215, 108, 215, 113, 219, 167, 219, 172, 219, 106, 219,
113, 219, 166, 223, 199, 184, 168, 223, 177, 223, 176, 223, 173, 223, 175, 227,
174, 227, 203, 187, 99, 231, 115, 231, 88, 231, 78, 189, 177, 231, 77, 235,
70, 235, 86, 238, 82, 238, 74, 238, 67, 240, 170, 194, 199, 195, 192, 242,
199, 244, 193, 245, 247, 196, 245, 248, 188, 215, 123, 205, 201, 211, 196, 211,
198, 179, 76, 215, 174, 219, 189, 219, 185, 184, 190, 187, 106, 227, 224, 227,
217, 231, 168, 189, 190, 235, 97, 235, 98, 238, 89, 238, 88, 193, 175, 240,
188, 242, 220, 244, 197, 246, 68, 248, 189, 166, 230, 191, 197, 211, 210, 215,
178, 179, 79, 219, 205, 219, 207, 184, 203, 227, 247, 231, 194, 231, 200, 235,
115, 238, 117, 195, 205, 196, 251, 202, 80, 179, 86, 191, 203, 247, 84, 168,
164, 224, 68, 246, 76, 176, 81, 179, 96, 182, 70, 219, 226, 181, 252, 184,
211, 224, 70, 187, 166, 189, 214, 189, 206, 231, 224, 191, 217, 191, 214, 238,
169, 240, 218, 240, 227, 243, 66, 196, 181, 246, 80, 248, 65, 168, 166, 224,
83, 219, 229, 193, 199, 184, 232, 168, 169, 184, 237, 184, 234, 189, 231, 235,
183, 240, 244, 248, 69, 168, 170, 211, 228, 224, 95, 231, 239, 173, 119, 219,
249, 219, 245, 224, 103, 228, 99, 232, 66, 231, 247, 191, 228, 240, 251, 243,
82, 196, 188, 247, 93, 249, 171, 235, 200, 211, 232, 220, 67, 220, 64, 228,
103, 232, 76, 235, 206, 241, 73, 197, 70, 168, 175, 197, 71, 168, 180, 208,
182, 176, 106, 215, 227, 179, 116, 220, 78, 224, 162, 187, 190, 191, 240, 235,
211, 202, 84, 205, 213, 173, 168, 211, 251, 215, 239, 220, 83, 224, 169, 241,
74, 241, 77, 176, 115, 221, 115, 232, 97, 238, 200, 243, 95, 198, 93, 212,
66, 179, 171, 220, 109, 182, 122, 220, 100, 185, 101, 185, 99, 224, 193, 228,
120, 228, 176, 228, 123, 232, 164, 232, 116, 232, 110, 232, 105, 235, 225, 191,
254, 192, 68, 235, 234, 193, 237, 193, 236, 241, 96, 241, 88, 241, 100, 243,
97, 195, 237, 244, 243, 244, 251, 244, 234, 197, 75, 247, 111, 248, 76, 249,
85, 170, 248, 182, 125, 224, 205, 236, 77, 238, 240, 245, 69, 170, 250, 203,
173, 170, 254, 176, 164, 179, 181, 220, 163, 185, 106, 192, 72, 212, 71, 187,
220, 171, 66, 224, 215, 192, 76, 241, 120, 197, 82, 171, 67, 192, 83, 228,
192, 232, 178, 241, 161, 243, 163, 173, 179, 243, 166, 173, 181, 220, 172, 232,
188, 236, 90, 239, 74, 243, 170, 197, 184, 173, 183, 196, 66, 173, 184, 182,
186, 187, 229, 232, 196, 239, 76, 195, 73, 245, 89, 173, 186, 249, 178, 187,
233, 190, 114, 236, 104, 239, 96, 241, 180, 243, 182, 246, 120, 197, 187, 198,
106, 176, 169, 192, 102, 247, 164, 187, 236, 236, 111, 243, 196, 198, 75, 243,
198, 241, 194, 228, 225, 232, 219, 236, 162, 239, 108, 241, 200, 195, 85, 243,
202, 245, 108, 245, 106, 246, 177, 247, 182, 248, 90, 248, 218, 249, 120, 179,
190, 232, 235, 236, 172, 236, 163, 194, 69, 241, 209, 239, 120, 243, 235, 245,
125, 245, 121, 197, 100, 246, 197, 248, 105, 247, 196, 248, 228, 249, 207, 179,
191, 239, 171, 197, 101, 196, 84, 239, 174, 194, 74, 247, 200, 248, 120, 246,
208, 245, 185, 247, 204, 243, 250, 197, 198, 249, 211, 246, 213, 250, 64, 250,
84, 250, 104, 250, 124, 250, 178, 250, 198, 250, 218, 250, 238, 251, 67, 251,
87, 251, 107, 251, 161, 251, 181, 251, 201, 251, 221, 251, 241, 252, 70, 252,
90, 252, 110, 252, 164, 252, 184, 252, 204, 252, 224, 252, 244, 253, 73, 253,
93, 253, 113, 253, 167, 253, 187, 253, 207, 253, 227, 253, 247, 254, 76, 254,
96, 254, 116, 254, 170, 254, 190, 254, 210, 254, 230, 254, 250, 142, 79, 142,
99, 142, 119, 142, 173, 142, 193, 142, 213, 142, 233, 142, 253, 143, 82, 143,
102, 143, 122, 143, 176, 143, 196, 143, 216, 143, 236, 144, 65, 144, 85, 144,
105, 144, 125, 144, 179, 144, 199, 144, 219, 144, 239, 145, 68, 145, 88, 145,
108, 145, 162, 145, 182, 145, 202, 145, 222, 145, 242, 146, 71, 146, 91, 146,
111, 146, 165, 146, 185, 146, 205, 146, 225, 146, 245, 147, 74, 147, 94, 147,
114, 147, 168, 147, 188, 147, 208, 147, 228, 147, 248, 148, 77, 148, 97, 148,
117, 148, 171, 148, 191, 148, 211, 148, 231, 148, 251, 149, 80, 149, 100, 149,
120, 149, 174, 149, 194, 149, 214, 149, 234, 149, 254, 150, 83, 150, 103, 150,
123, 150, 177, 150, 197, 150, 217, 150, 237, 151, 66, 151, 86, 151, 106, 151,
126, 151, 180, 151, 200, 151, 220, 151, 240, 152, 69, 152, 89, 152, 109, 152,
163, 152, 183, 152, 203, 152, 223, 152, 243, 153, 72, 153, 92, 153, 112, 153,
166, 153, 186, 153, 206, 153, 226, 153, 246, 154, 75, 154, 95, 154, 115, 154,
169, 154, 189, 154, 209, 154, 229, 154, 249, 155, 78, 155, 98, 155, 118, 155,
172, 155, 192, 155, 212, 155, 232, 155, 252, 156, 81, 156, 101, 156, 121, 156,
175, 156, 195, 156, 215, 156, 235, 157, 64, 157, 84, 157, 104, 157, 124, 157,
178, 157, 198, 157, 218, 157, 238, 158, 67, 158, 87, 158, 107, 158, 161, 158,
181, 158, 201, 158, 221, 158, 241, 159, 70, 159, 90, 159, 110, 159, 164, 159,
184, 159, 204, 159, 224, 159, 244, 160, 73, 160, 93, 160, 113, 160, 167, 160,
187, 160, 207, 160, 227, 160, 247, 129, 76, 129, 96, 129, 116, 129, 170, 129,
190, 129, 210, 129, 230, 129, 250, 130, 79, 130, 99, 130, 119, 130, 173, 130,
193, 130, 213, 130, 233, 130, 253, 131, 82, 131, 102, 131, 122, 131, 176, 131,
196, 131, 216, 131, 236, 132, 65, 132, 85, 132, 105, 132, 125, 132, 179, 132,
199, 132, 219, 132, 239, 133, 68, 133, 88, 133, 108, 133, 162, 133, 182, 133,
202, 133, 222, 133, 242, 134, 71, 134, 91, 134, 111, 134, 165, 134, 185, 134,
205, 134, 225, 134, 245, 135, 74, 135, 94, 135, 114, 135, 168, 135, 188, 135,
208, 135, 228, 135, 248, 136, 77, 136, 97, 136, 117, 136, 171, 136, 191, 136,
211, 136, 231, 136, 251, 137, 80, 137, 100, 137, 120, 137, 174, 137, 194, 137,
214, 137, 234, 137, 254, 138, 83, 138, 103, 138, 123, 138, 177, 138, 197, 138,
217, 138, 237, 139, 66, 139, 86, 139, 106, 139, 126, 139, 180, 139, 200, 139,
220, 139, 240, 140, 69, 140, 89, 140, 109, 140, 163, 140, 183, 140, 203, 140,
223, 140, 243, 141, 72, 141, 92, 141, 112, 141, 166, 141, 186, 141, 206, 141,
226, 141, 246, 198, 172, 198, 192, 198, 212, 198, 232, 198, 252, 199, 81, 199,
101, 199, 121, 199, 175, 199, 195, 199, 215, 199, 235, 200, 64, 200, 84, 200,
104, 200, 124, 200, 178, 200, 198, 200, 218, 200, 238, 255, 201, 74, 161, 74,
161, 124, 161, 125, 161, 73, 162, 180, 162, 215, 161, 196, 162, 251, 162, 70
            });

        super.setUp();
    }

}
