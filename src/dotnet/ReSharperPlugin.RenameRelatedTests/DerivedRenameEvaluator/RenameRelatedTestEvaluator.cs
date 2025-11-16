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
        return [];
    }

    public IEnumerable<IDeclaredElement> CreateFromReference(IReference reference, IDeclaredElement declaredElement, IProgressIndicator pi)
    {
        if (reference.GetTreeNode() is not ICSharpTreeNode cSharpTreeNode)
            return [];
        if (cSharpTreeNode.GetContainingTypeDeclaration() is not IClassDeclaration classDeclaration)
            return [];
        if (classDeclaration.DeclaredName != declaredElement.ShortName + "Tests")
            return [];
        return [classDeclaration.DeclaredElement];
    }
}
