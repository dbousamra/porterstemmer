package brill

object BrillTaggerParser {

  def getSplitted() = {
    val text = """A/DT tree/NN is/VBZ a/DT tall/JJ perennial/JJ plant/NN with/IN a/DT woody/JJ stem/NN or/CC trunk/NN ./. 
It/PRP differs/VBZ from/IN a/DT shrub/NN in/IN that/IN it/PRP is/VBZ usually/RB larger/JJR and/CC typically/RB has/VBZ a/DT single/JJ main/JJ stem/NN whereas/IN a/DT shrub/NN usually/RB has/VBZ several/JJ stems/NNS ./. 
[/( 2/CD ]/) There/EX are/VBP two/CD principal/JJ groups/NNS of/IN vascular/JJ or/CC higher/JJR plants/NNS ,/, the/DT gymnosperms/NNS and/CC the/DT angiosperms/NNS ./. 
The/DT gymnosperms/NNS include/VBP conifers/NNS ,/, cycads/NNS ,/, ginkgophytes/NNS and/CC gnetales/NNS ./. 
They/PRP are/VBP characterised/VBN by/IN having/VBG naked/JJ seeds/NNS that/WDT are/VBP not/RB contained/VBN in/IN ovaries/NNS ./. 
The/DT angiosperms/NNS are/VBP the/DT flowering/NN plants/NNS and/CC these/DT are/VBP characterised/VBN by/IN having/VBG seeds/NNS formed/VBN in/IN ovaries/NNS which/WDT have/VBP endosperm/NN surrounding/VBG the/DT embryo/NN ./. 
[/( 3/NNP ]/) Angiosperm/NNP trees/NNS are/VBP also/RB known/VBN as/IN broad-leaved/JJ trees/NNS ./. 
Most/JJS angiosperm/NN trees/NNS are/VBP dicotyledons/NNS ,/, so/RB named/VBN because/IN the/DT seeds/NNS contain/VBP two/CD cotyledons/NNS or/CC seed/NN leaves/VBZ ,/, but/CC one/CD important/JJ group/NN ,/, the/DT palms/NNS ,/, is/VBZ monocotyledonous/JJ ,/, having/VBG a/DT single/JJ cotyledon[citation/NN needed/VBN ]/) ./. 
Palms/NNS are/VBP herbs/NNS ,/, not/RB trees/NNS [/( 4/CD ]/) [/( 5/NNP ]/) ./. 
Monocots/NNS do/VBP not/RB undergo/VB secondary/JJ growth/NN and/CC never/RB produce/VB wood/NN [/( 6/NNP ]/) [7][8]/CD and/CC hence/RB do/VBP not/RB meet/VB the/DT definition/NN of/IN tree/NN used/VBN in/IN this/DT article/NN ./. 
In/IN many/JJ palms/NNS ,/, the/DT terminal/JJ bud/NN on/IN the/DT main/JJ stem/NN is/VBZ the/DT only/JJ one/CD to/TO develop/VB so/IN they/PRP have/VBP tall/JJ ,/, unbranched/JJ trunks/NNS with/IN spirally/RB arranged/VBN large/JJ leaves/NNS ./. 
Other/JJ palms/NNS have/VBP many/JJ stems/NNS ./. 
[9][clarification/NNP needed/VBD ]/) Some/DT of/IN the/DT tree/NN ferns/NNS ,/, order/NN Cyatheales/NNP ,/, have/VBP tree-like/JJ growth/NN forms/NNS ,/, growing/VBG up/IN to/TO 20/CD metres/NNS (/( 66/NNP ft/NN )/) but/CC they/PRP are/VBP structurally/RB very/RB different/JJ from/IN other/JJ trees[clarification/NN needed/VBN ]/) Their/PRP$ trunks/NNS are/VBP composed/VBN of/IN rhizomes/NNS which/WDT grow/VBP vertically/RB and/CC which/WDT are/VBP covered/VBN by/IN numerous/JJ adventitious/JJ roots/NNS ./. 
[/( 10/CD ]/) Trees/NNP are/VBP either/DT evergreen/JJ ,/, having/VBG foliage/NN that/WDT persists/VBZ and/CC remains/VBZ green/JJ throughout/IN the/DT year,[11]/JJ or/CC deciduous/JJ ,/, shedding/VBG their/PRP$ leaves/NNS at/IN the/DT end/NN of/IN the/DT growing/VBG season/NN and/CC then/RB having/VBG a/DT dormant/JJ period/NN without/IN foliage/NN ./. 
[/( 12/CD ]/) Most/JJS conifers/NNS are/VBP evergreens/NNS but/CC larches/NNS (/( Larix/NNP and/CC Pseudolarix/NNP )/) are/VBP deciduous/JJ ,/, dropping/VBG their/PRP$ needles/NNS each/DT autumn/NN ,/, and/CC some/DT species/NN of/IN cypress/NN (/( Glyptostrobus/NNP ,/, Metasequoia/NNP and/CC Taxodium/NNP )/) shed/NN small/JJ leafy/JJ shoots/NNS annually/RB in/IN a/DT process/NN known/VBN as/IN cladoptosis/NN ./. 
[/( 2/CD ]/) The/DT crown/NN is/VBZ a/DT name/NN for/IN the/DT upper/JJ part/NN of/IN a/DT tree/NN including/VBG the/DT branches/NNS and/CC leaves/VBZ [/( 13/CD ]/) and/CC the/DT uppermost/JJS layer/NN in/IN a/DT forest/NN ,/, formed/VBN by/IN the/DT crowns/NNS of/IN the/DT trees/NNS ,/, is/VBZ known/VBN as/IN the/DT canopy/NN ./. 
[/( 14/CD ]/) A/DT sapling/NN is/VBZ a/DT young/JJ tree/NN ./. 
[/( 15/CD ]/) The/DT wood/NN of/IN conifers/NNS is/VBZ known/VBN as/IN softwood/JJ while/IN that/DT of/IN broad-leaved/JJ trees/NNS is/VBZ hardwood/JJ ./. 
[/( 16/CD ]/) A/DT small/JJ wooded/JJ area/NN ,/, usually/RB with/IN no/DT undergrowth/NN ,/, is/VBZ called/VBN a/DT grove/NN [/( 17/CD ]/) and/CC a/DT small/JJ wood/NN or/CC thicket/NN of/IN trees/NNS and/CC bushes/NNS is/VBZ called/VBN a/DT coppice/NN or/CC copse/NN ./. 
[/( 18/CD ]/) A/DT large/JJ area/NN of/IN land/NN covered/VBN with/IN trees/NNS and/CC undergrowth/NN is/VBZ called/VBN woodland/JJ or/CC forest/NN ./. 
[/( 19/CD ]/) An/DT area/NN of/IN woodland/JJ composed/VBN primarily/RB of/IN trees/NNS established/VBN by/IN planting/NN or/CC """

    text
      .split("\n")
      .map(line => line.split(" "))
      .flatten
      .filter(w => w.endsWith("/NN") || w.endsWith("/NNS") || w.endsWith("/NNP") || w.endsWith("/NNPS"))
      .map { word =>
        word.stripSuffix("/NN").stripSuffix("/NNP").stripSuffix("/NNS").stripSuffix("/NNPS")
      }.toList
  }

}