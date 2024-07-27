using System;
using System.Collections.Generic;
using JetBrains.Application.Progress;
using JetBrains.ReSharper.Psi;
using JetBrains.ReSharper.Psi.CSharp.Tree;
using JetBrains.ReSharper.Psi.Resolve;
using JetBrains.ReSharper.Refactorings.Rename;

namespace ReSharperPlugin.RenameRelatedTests.DerivedRenameEvaluator;

[DerivedRenamesEvaluator]
public class RenameRelatedTestEvaluator : IDerivedRenamesEvaluator
{
    public bool SuggestedElementsHaveDerivedName => true;

    public IEnumerable<IDeclaredElement> CreateFromElement(IEnumerable<IDeclaredElement> initialElements, DerivedElement derivedElement, IProgressIndicator pi)
    {
        return Array.Empty<IDeclaredElement>();
    }

    public IEnumerable<IDeclaredElement> CreateFromReference(IReference reference, IDeclaredElement declaredElement, IProgressIndicator pi)
    {
        if (!(reference.GetTreeNode() is ICSharpTreeNode cSharpTreeNode))
            return Array.Empty<IDeclaredElement>();
        if (!(cSharpTreeNode.GetContainingTypeDeclaration() is IClassDeclaration classDeclaration))
            return Array.Empty<IDeclaredElement>();
        if (classDeclaration.DeclaredName != declaredElement.ShortName + "Tests")
            return Array.Empty<IDeclaredElement>();
        return new[] {classDeclaration.DeclaredElement};
    }
}