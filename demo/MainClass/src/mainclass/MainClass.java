<?xml version="1.0" encoding="utf-8"?>
<Scintilla xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
	<keyword-classes>
		<keyword-class name="cpp-primary-keywords">
			and and_eq auto bitand bitor bool char class const double enum explicit export extern false float friend inline int long mutable namespace not not_eq or 
			or_eq register short signed static struct template true typedef typename union unsigned using virtual void volatile wchar_t xor xor_eq
		</keyword-class>
		<keyword-class name="cpp-additional-keywords">
			asm break catch case continue compl const_cast dynamic_cast do default delete else for goto if new operator public private protected return reinterpret_cast 
			sizeof static_cast switch this throw try typeid while
		</keyword-class>
	</keyword-classes>
	<languages>
		<language name="cpp">
			<lexer name="cpp" style-bits="7" />
			<character-class><![CDATA[_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789]]></character-class>
			<line-comment><![CDATA[//]]></line-comment>
			<comment-start><![CDATA[/*]]></comment-start>
			<comment-end><![CDATA[*/]]></comment-end>
			<file-