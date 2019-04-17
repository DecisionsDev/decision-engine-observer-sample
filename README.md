Table of Contents

1. [Introduction](#intro)
2. [Version(s) Supported](#versions)
3. [Usage Instructions](#instruction)
4. [License information](#license)

Introduction<a name="intro"></a>
============

This document provides an example implementation of a 
<a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/api/html/com/ibm/rules/engine/observer/Observable.html">Rule Engine Observer</a>. The code is provided and can be extended as needed. An Observer is used to receive notifications from an Observable object (You can use it for additional logging for instance).

In the included example, we implement <a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/jrules2dotnet/html/T_IBM_Rules_RVE_RuleDef_Runtime_RuleEngineObserver.htm">RuleEngineObserver</a>, <a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/jrules2dotnet/html/T_IBM_Rules_RVE_Ruleflow_Runtime_RuleflowObserver.htm">RuleflowObserver</a>, <a href="https://www.ibm.com/support/knowledgecenter/en/SSQP76_8.7.0/com.ibm.odm.dserver.rules.ref.designer/html/jrules2dotnet/html/T_IBM_Rules_RVE_RuleDef_Runtime_AgendaObserver.htm">AgendaObserver</a>

You can import this sample into an existing Rule Designer or Decision Center to View.

In the XOM project "TestObserverForOoC-xom" we define the request and a response objects. We also inplement the Observer in EngineObserverDE.java
The EngineObserverDE class overrides the methods in observable, and adds to its trace whenever one of these is called during a notification event. 
It uses an EngineTrace Object to store all the notification traces, and this object is printed when the observer is removed.
We also added an xml wrapper to EngineTrace.java so it behaves properly in htds.

The Main Rule Project "TestObserverForOoC-service" runs a few sample rules (RuleA, RuleB), and calls the functions "initialize" and "finalize" in the ruleflow "Main flow".
These functions add/remove the observer object to the rule engine.

The BOM defines the add and remove observer functions.

The response object contains an EngineTrace that is set when the observer is added (in the B2X).
When the observer is notified of something by the engine, we add a TraceElement with a message to this EngineTrace.


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

License Information<a name="license"></a>
====================
The Dockerfiles and associated scripts found in this project are licensed under the [Apache License 2.0](LICENSE).

# Notice
© Copyright IBM Corporation 2019.
