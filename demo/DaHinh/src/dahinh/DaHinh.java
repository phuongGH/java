﻿<?xml version="1.0" encoding="utf-8"?>
<project version="2">
  <!-- Output SWF options -->
  <output>
    <movie outputType="CustomBuild" />
    <movie input="" />
    <movie path="" />
    <movie fps="0" />
    <movie width="0" />
    <movie height="0" />
    <movie version="1" />
    <movie minorVersion="0" />
    <movie platform="Default" />
    <movie background="#000000" />
  </output>
  <!-- Other classes to be compiled into your SWF -->
  <classpaths>
    <!-- example: <class path="..." /> -->
  </classpaths>
  <!-- Class files to compile (other referenced classes will automatically be included) -->
  <compileTargets>
    <!-- example: <compile path="..." /> -->
  </compileTargets>
  <!-- Paths to exclude from the Project Explorer tree -->
  <hiddenPaths>
    <hidden path="COMPLETION" />
  </hiddenPaths>
  <!-- Executed before build -->
  <preBuildCommand>build.cmd --define BUILD='$(BuildConfig)' --compilation_level SIMPLE_OPTIMIZATIONS --