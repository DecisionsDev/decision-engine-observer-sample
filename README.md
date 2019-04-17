Table of Contents

1. [Introduction](#intro)
2. [Version(s) Supported](#versions)
3. [Usage Instructions](#instruction)
4. [Details](#details)
5. [License information](#license)

Introduction<a name="intro"></a>
============

This document provides an example implementation of a 
<a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/api/html/com/ibm/rules/engine/observer/Observable.html">Rule Engine Observer</a>. The code is provided and can be extended as needed. An Observer is used to receive notifications from an Observable object (You can use it for additional logging for instance).

You can import this sample into an existing Rule Designer or Decision Center to View.

Version(s) Supported<a name="versions"></a>
====================

IBM ODM 8.7 or greater

Usage Instructions<a name="instruction"></a>
===================

1. Import into decision center (or rule designer).
2. Update the deployment configuration to include your RES Server. 
3. Deploy to the RES server.
4. Log onto the RES server and navaigate to the ruleapp "MyTest" in the explorer tab. Open up ruleset "runRules". 
5. Retreive HTDS description file, select REST, format WADL, and Test.
6. Click on "Execute Request"; you will see trace messages in the response printed by our observer.

Details<a name="details"></a>
============

Inside the XOM project (TestObserverForOoC-xom):

Response/Request Classes:



TraceElement:

EngineTrace:
We also added an xml wrapper so it behaves properly in htds.

EngineObserverDE:

This class implements three children of Observer; <a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/jrules2dotnet/html/T_IBM_Rules_RVE_RuleDef_Runtime_RuleEngineObserver.htm">RuleEngineObserver</a>, <a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/jrules2dotnet/html/T_IBM_Rules_RVE_Ruleflow_Runtime_RuleflowObserver.htm">RuleflowObserver</a>, and <a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/jrules2dotnet/html/T_IBM_Rules_RVE_RuleDef_Runtime_AgendaObserver.htm">AgendaObserver</a>. It overrides the reuired methods for these interfaces and adds to its trace whenever one of these is called during a notification event. 
It uses an EngineTrace Object to store all the notification traces, and this object is printed when the observer is removed.

Inside the Main Rule Project (TestObserverForOoC-service):

Rules:

This project has a few sample rules (rule "RuleA", and decision table "RuleB"). These are filler rules, just created so that there are rules to run in the ruleflow.

Functions ("initialize" and "finalize"):

The function "initialize" creates a new response object, calls the BOM method add with the created response as the parameter.
The function "finalize" calls the BOM method remove to remove the observer, and print the messages it has stored.

Ruleflow ("Main flow"):

This calls the function "initialize" at the start, then runs the rules, and finally calls the function "finalize" during cleanup.

Variables:
The variables "request" and "response" are instantiations of the respective objects in the XOM project.

BOM:

The response object contains an EngineTrace that is set when the observer is added (in the B2X).
When the observer is notified of something by the engine, we add a TraceElement with a message to this EngineTrace.

dont verbalize so that it doesn't show up for business users.

Deployment:

There is a decision operation "TestObserverOperation", which defines that a request is required for input, and a response is given on output. There is also a deployment configuration which defines the target RES server.

License Information<a name="license"></a>
====================
The Dockerfiles and associated scripts found in this project are licensed under the [Apache License 2.0](LICENSE).

# Notice
© Copyright IBM Corporation 2019.
